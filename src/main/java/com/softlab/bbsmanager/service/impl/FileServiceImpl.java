package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.FileProperties;
import com.softlab.bbsmanager.common.FileException;
import com.softlab.bbsmanager.core.model.File;
import com.softlab.bbsmanager.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @ClassName FileServiceImpl
 * @Description 文件上传下载处理层
 * @Author gwx
 * @Date 2020/2/23 19:09
 * @Version 1.0
 */
public class FileServiceImpl implements FileService {

    private final Path fileStorageLocation;

    @Autowired
    public FileServiceImpl(FileProperties fileProperties) throws FileException {
        this.fileStorageLocation = Paths.get(fileProperties.getUploadDir())
                .toAbsolutePath()
                .toAbsolutePath()
                .normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        }catch (IOException e){
            throw new FileException("无法创建将要上传文件相应目录",e);
        }
    }

    @Override
    public String fileStore(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")){
                throw new FileException("抱歉，文件名包含无效路径！" + fileName);
            }

            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        }catch (IOException e){
            throw new FileException("无法储存文件:" + fileName + "！请再次尝试！",e);
        }
    }

    @Override
    public Resource loadFileResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            }else {
                throw new FileException("找不到文件：" + fileName);
            }
        }catch (MalformedURLException ex){
            throw new FileException("找不到文件："+ fileName);
        }
    }
}
