package com.softlab.bbsmanager.common.util;

import com.softlab.bbsmanager.core.mapper.UserMapper;
import com.softlab.bbsmanager.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @ClassName TokenUtil
 * @Description token处理类
 * @Author gwx
 * @Date 2020/2/23 9:32
 * @Version 1.0
 */
public class TokenUtil {

    private static UserMapper userMapper;

    @Autowired
    public TokenUtil(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 随机生成字符串，作为用户的token
     * @return
     */
    public static String getToken(){
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 通过token获取用户
     * @param request
     * @return
     */
    public static User getUserByToken(HttpServletRequest request){
        User user = null;
        String token = request.getHeader("token");

        if (token != null) {
            user = userMapper.selectUserByToken(token);
        }
        return user;
    }

}
