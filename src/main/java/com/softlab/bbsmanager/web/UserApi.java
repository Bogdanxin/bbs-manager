package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.common.util.JsonUtil;
import com.softlab.bbsmanager.common.util.VerifyUtil;
import com.softlab.bbsmanager.core.model.User;
import com.softlab.bbsmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserApi
 * @Description user的web层，连接前端和后端
 * @Author gwx
 * @Date 2020/2/23 16:42
 * @Version 1.0
 */
@RestController
public class UserApi {

    private final static Logger logger = LoggerFactory.getLogger(UserApi.class);
    private final UserService userService;
    private final static int BOARD_MASTER = 3;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
    public RestData getAllUsers(/*HttpServletRequest request*/){
        logger.info("get all users");

        /*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER){
            return new RestData(1,"用户未授权！");
        }*/
        try {
            return new RestData(userService.selectAllUsers());
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getUserById/{id}", method = RequestMethod.GET)
    public RestData getUserById(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("get user by id: "+ id);

        /*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*/

        try {
            return new RestData(userService.selectUserById(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteUserById/{id}", method = RequestMethod.DELETE)
    public RestData deleteUserById(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("delete user by id : "+id);
        /*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*/

        try {
            return userService.deleteUserById(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/updateUserInformation/{id}", method = RequestMethod.POST)
    public RestData updateUserInformation(@RequestBody User user,@PathVariable String id){
        logger.info("update user information :" + JsonUtil.getJsonFromObj(user));

        try {
            return userService.updateUserInformationByCondition(user, id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/exit/{id}", method = RequestMethod.POST)
    public RestData exit(@PathVariable String id){
        logger.info("exit id: "+ id);

        try {
            return userService.exit(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestData login(@RequestBody User user){
        logger.info("user login : "+JsonUtil.getJsonFromObj(user));

        if (user.getUserPassword() != null && user.getUserId() != null) {
            try {
                return new RestData(userService.login(user.getUserId(), user.getUserPassword()));
            }catch (BbsException e){
                return new RestData(1,e.getMessage());
            }
        }else {
            return new RestData(1,"请输入用户名或密码！");
        }
    }


}
