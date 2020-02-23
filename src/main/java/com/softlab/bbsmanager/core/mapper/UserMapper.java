package com.softlab.bbsmanager.core.mapper;

import com.softlab.bbsmanager.core.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description 对user相关的数据库操作
 * @Author gwx
 * @Date 2020/2/22 17:41
 * @Version 1.0
 */
@Mapper
@Repository
public interface UserMapper {
    /**
     * 添加一个用户，用于注册
     * 使用动态insert，便于添加信息
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 删除指定i的用户
     * @param userId
     * @return
     */
    int deleteUserById(String userId);

    /**
     * 锁定指定id的用户，将其userType置为0
     * @param userId
     * @return
     */
    int lockUserById(String userId);

    /**
     * 根据不同情况查找索用符合条件的用户，
     * 一般情况不用，只用于条件不清楚的时候
     * @param user
     * @return
     */
    List<User> selectUserByCondition(User user);

    /**
     * 根据token查找用户
     * @param token
     * @return
     */
    User selectUserByToken(String token);

    /**
     * 查找所有的用户
     * @return
     */
    List<User> selectAllUsers();

    /**
     * 查找指定id的用户
     * @param userId
     * @return
     */
    User selectUserById(String userId);

    /**
     * 修改指定id用户的token
     * @param token
     * @param userId
     * @return
     */
    int updateTokenByUserId(@Param("token")String token,
                            @Param("userId")String userId);

    /**
     * 根据用户的id和密码查找，用作登录
     * @param userId
     * @param password
     * @return
     */
    User selectUserByIdAndPassword(@Param("userId") String userId,
                                   @Param("password") String password);

    /**
     * 修改用户密码
     * @param newPassword
     * @param oldPassword
     * @param userId
     * @return
     */
    int updatePassword(@Param("newPassword")String newPassword,
                       @Param("oldPassword")String oldPassword,
                       @Param("userId") String userId);

    /**
     * 根据不同条件，修改指定id的用户一般信息
     * 如用户名，学院，班级，头像等等
     * @param user
     * @param userId
     * @return
     */
    int updateUserInformationByCondition(@Param("user") User user,
                                         @Param("userId") String userId);

    /**
     * 将用户的token置空，用来退出登录
     * @param userId
     * @return
     */
    int updateTokenNullById(String userId);
}
