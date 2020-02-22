package com.softlab.bbsmanager.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @ClassName RestData
 * @Description 将web层处理好的数据传递到前端
 * @Author gwx
 * @Date 2020/2/22 16:14
 * @Version 1.0
 */
public class RestData {

    /**
     * code默认为0，代表处理成功，1为出现错误
     */
    private int code;

    /**
     * message代表处理信息，
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    /**
     * data代表的是将对象处理后直接传递到前端
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    /**
     * 使用这个构造方法一般代表着操作失败，
     * 将code和message传入道前端
     * @param code
     * @param message
     */
    public RestData(int code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * 这个构造方法一般代表着成功，
     * 直接将实体类传入到前端
     * @param data
     */
    public RestData(Object data){
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
