package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.mapper.UserMapper;
import com.softlab.bbsmanager.core.model.User;
import com.softlab.bbsmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description service层操作
 * @Author gwx
 * @Date 2020/2/23 15:55
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public RestData insertUser(User user) throws BbsException {
        if (userMapper.selectUserById(user.getUserId()) != null) {
            return new RestData(1,"已有此id，请更改后重试！");
        }

        if (userMapper.insertUser(user) > 0) {
            return new RestData(0,"添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData deleteUserById(String userId) throws BbsException {
        if (userMapper.deleteUserById(userId) == 1) {
            return new RestData(0, "删除成功！");
        }else {
            throw new BbsException("删除失败！");
        }
    }

    @Override
    public RestData updateUserInformationByCondition(User user, String userId) throws BbsException {
        //先判断这里的用户id是不是存在
        if (userMapper.selectUserById(userId) == null) {
            return new RestData(1,"该用户不存在！");
        }
        if (userMapper.updateUserInformationByCondition(user, userId) > 0) {
            return new RestData(0,"修改成功！");
        }else {
            throw new BbsException("修改失败！");
        }
    }

    @Override
    public Map<String, Object> selectUserById(String userId) throws BbsException {
        Map<String, Object> map = null;
        User user = userMapper.selectUserById(userId);
        if (user != null) {
            map = new HashMap<>(14);
            map.put("userId", user.getUserId());
            map.put("userName", user.getUserName());
            map.put("userSex", user.getUserSex());
            map.put("userEmail", user.getUserEmail());
            map.put("userPhone", user.getUserPhone());
            map.put("userImage", user.getUserImage());
            map.put("userGrade", user.getUserGrade());
            map.put("userMajor", user.getUserMajor());
            map.put("userAcademy", user.getUserAcademy());
            map.put("userIntroduction", user.getUserIntroduction());
            map.put("userIntegral", user.getUserIntegral());
            map.put("userType", user.getUserType());
            map.put("userToken", user.getUserToken());
        }else {
            throw new BbsException("查找失败！");
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> selectAllUsers() throws BbsException {
        List<User>  users = userMapper.selectAllUsers();
        List<Map<String, Object>> al = new ArrayList<>();
        if (users != null) {
            for (User user : users){
                Map<String, Object> map = new HashMap<>(14);
                map.put("userId", user.getUserId());
                map.put("userName", user.getUserName());
                map.put("userSex", user.getUserSex());
                map.put("userEmail", user.getUserEmail());
                map.put("userPhone", user.getUserPhone());
                map.put("userImage", user.getUserImage());
                map.put("userGrade", user.getUserGrade());
                map.put("userMajor", user.getUserMajor());
                map.put("userAcademy", user.getUserAcademy());
                map.put("userIntroduction", user.getUserIntroduction());
                map.put("userIntegral", user.getUserIntegral());
                map.put("userType", user.getUserType());
                map.put("userToken", user.getUserToken());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }
        return al;
    }

    @Override
    public RestData updatePassword(String newPassword, String oldPassword, String userId) throws BbsException {
        if (userMapper.selectUserByIdAndPassword(userId, oldPassword) == null) {
            return new RestData(1,"用户名或密码错误！");
        }
        if (userMapper.updatePassword(newPassword, oldPassword, userId) > 0) {
            return new RestData(0, "修改成功!");
        }else {
            throw new BbsException("修改失败！");
        }
    }

    @Override
    public RestData exit(String userId) throws BbsException {
        if (userMapper.updateTokenNullById(userId) > 0) {
            return new RestData(0,"退出成功！");
        }else {
            throw new BbsException("退出失败！");
        }
    }

    @Override
    public Map<String, Object> login(String userId, String password) throws BbsException {
        User user = userMapper.selectUserByIdAndPassword(userId, password);
        Map<String, Object> map = null;
        if (user != null) {
            map = new HashMap<>(3);
            map.put("userId", user.getUserId());
            map.put("userToken", user.getUserToken());
            map.put("userType", user.getUserType());
        }else {
            throw new BbsException("密码或用户名错误！");
        }
        return map;
    }


}
