package com.softlab.bbsmanager;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName FileProperties
 * @Description
 * @Author gwx
 * @Date 2020/2/23 19:14
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "file")
public class FileProperties {

    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
