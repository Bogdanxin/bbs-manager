package com.softlab.bbsmanager.common;

/**
 * @ClassName FileException
 * @Description 文件异常类，用来处理文件传输上的异常
 * @Author gwx
 * @Date 2020/2/22 16:43
 * @Version 1.0
 */
public class FileException extends Exception {
    public FileException(String message, Throwable cause){
        super(message, cause);
    }

    public FileException(String message){
        super(message);
    }
}
