package com.softlab.bbsmanager.common;

/**
 * @ClassName BbsException
 * @Description 继承Exception类，处理一般的异常
 * @Author gwx
 * @Date 2020/2/22 16:39
 * @Version 1.0
 */
public class BbsException extends Exception {
    public BbsException(String message){
        super(message);
    }
}
