package com.softlab.bbsmanager.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName FileService
 * @Description 文件下载，上传处理接口
 * @Author gwx
 * @Date 2020/2/23 19:06
 * @Version 1.0
 */
public interface FileService {

    /**
     * 存储文件，前端传向后端
     * @param file
     * @return
     */
    String fileStore(MultipartFile file);

    /**
     * 下载文件，后端传向前端
     * @param fileName
     * @return
     */
    Resource loadFileResource(String fileName);
}
