package com.softlab.bbsmanager.common.util;

import com.softlab.bbsmanager.core.mapper.UserMapper;
import com.softlab.bbsmanager.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName VerifyUtil
 * @Description 确定用户类型
 * @Author gwx
 * @Date 2020/2/23 9:27
 * @Version 1.0
 */
public class VerifyUtil {

    private static UserMapper userMapper;

    @Autowired
    public VerifyUtil(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 确定用户类型
     * @param request
     * @return
     */
    public static Integer verifyUserType(HttpServletRequest request){
        String token = request.getHeader("token");
        User user = userMapper.selectUserByToken(token);
        if (user == null) {
            return 0;
        }else {
            return user.getUserType();
        }
    }
}
