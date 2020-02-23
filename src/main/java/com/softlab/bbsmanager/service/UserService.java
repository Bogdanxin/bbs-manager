package com.softlab.bbsmanager.service;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.model.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description 用户service层
 * @Author gwx
 * @Date 2020/2/22 19:56
 * @Version 1.0
 */
public interface UserService {

    /**
     * 添加一个user
     * @param user
     * @return
     * @throws BbsException
     */
    RestData insertUser(User user) throws BbsException;

    /**
     * 删除指定id的user
     * @param userId
     * @return
     * @throws BbsException
     */
    RestData deleteUserById(String userId) throws BbsException;

    /**
     * 修改user
     * @param user
     * @param userId
     * @return
     * @throws BbsException
     */
    RestData updateUserInformationByCondition(User user, String userId) throws BbsException;

    /**
     * 根据指定id查找user
     * @param userId
     * @return
     * @throws BbsException
     */
    Map<String, Object> selectUserById(String userId) throws BbsException;

    /**
     * 查找所有的user
     * @return
     * @throws BbsException
     */
    List<Map<String, Object>> selectAllUsers() throws BbsException;

    /**
     * 修改密码
     * @param newPassword
     * @param oldPassword
     * @param userId
     * @return
     * @throws BbsException
     */
    RestData updatePassword(String newPassword, String oldPassword, String userId) throws BbsException;

    /**
     * 退出登录
     * @param userId
     * @return
     * @throws BbsException
     */
    RestData exit(String userId) throws BbsException;

    /**
     * 登录
     * @param userId
     * @param password
     * @return
     * @throws BbsException
     */
    Map<String, Object> login(String userId, String password) throws BbsException;
}
