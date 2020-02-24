package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.core.model.File;
import com.softlab.bbsmanager.service.FileService;
import com.softlab.bbsmanager.service.impl.FileServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName FileApi
 * @Description web层文件传输类，管理文件的上传和下载
 * @Author gwx
 * @Date 2020/2/24 9:55
 * @Version 1.0
 */
@RestController
public class FileApi {

    private final static Logger logger = LoggerFactory.getLogger(FileApi.class);
    private final FileServiceImpl fileService;

    @Autowired
    public FileApi(FileServiceImpl fileService) {
        this.fileService = fileService;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public File uploadFile(@RequestParam("file")MultipartFile file){
        String fileName = fileService.fileStore(file);

        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/downloadFile")
                .path(fileName)
                .toUriString();

        return new File(fileName, fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/uploadMultipleFiles", method = RequestMethod.POST)
    public List<File> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    /**
     * 注意：在下载时候，要把文件名编解码，尤其是中文，这样才能
     * @param fileName
     * @param request
     * @return
     */
    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Resource resource = fileService.loadFileResource(fileName);

        String contentType = null;
        try {
            contentType = request.getServletContext()
                    .getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException ex){
            logger.info("无法确定文件类型！");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename = \""
                        + resource.getFilename() + "\"")
                .body(resource);
    }
}
