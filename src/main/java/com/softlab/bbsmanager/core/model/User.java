package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName User
 * @Description 用户实体类User
 * @Author gwx
 * @Date 2020/2/22 17:36
 * @Version 1.0
 */
@Data
public class User {

    /**
     * 用户的 id，用u开头，之后是学生的学号
     * 用学号 u201XXXXXXX
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户手机哦
     */
    private int userPhone;

    /**
     * 用户头像，是存放图像的路径
     */
    private String userImage;

    /**
     * 用户年级
     */
    private String userGrade;

    /**
     * 用户专业
     */
    private String userMajor;

    /**
     * 用户学院
     */
    private String userAcademy;

    /**
     * 用户简介文本存储路径
     */
    private String userIntroduction;

    /**
     * 用户的积分
     */
    private int userIntegral;

    /**
     * 用户的类型
     * 0 = 普通用户， 1 = 版主
     */
    private int userType;

    /**
     * 用户token
     */
    private String userToken;
}
