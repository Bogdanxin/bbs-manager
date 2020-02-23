package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName File
 * @Description 文件类
 * @Author gwx
 * @Date 2020/2/23 19:03
 * @Version 1.0
 */
@Data
public class File {

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件下载地址
     */
    private String fileDownloadUri;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private long fileSize;

    public File(String fileName, String fileDownloadUri, String fileType, long fileSize) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

}
