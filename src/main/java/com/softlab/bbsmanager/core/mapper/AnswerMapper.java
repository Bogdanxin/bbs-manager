package com.softlab.bbsmanager.core.mapper;

import com.softlab.bbsmanager.core.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName AnswerMapper
 * @Description 对answer数据库操作
 * @Author gwx
 * @Date 2020/2/24 10:54
 * @Version 1.0
 */
@Mapper
@Repository
public interface AnswerMapper {

    /**
     * 添加一个回答
     * @param answer
     * @param questionId
     * @return
     */
    int insertAnswer(@Param("answer") Answer answer,
                     @Param("questionId") String questionId);

    /**
     * 修改回答
     * @param answer
     * @param answerId
     * @return
     */
    int updateAnswer(@Param("answer") Answer answer,
                     @Param("answerId") String answerId);

    /**
     * 删除指定id的回答
     * @param answerId
     * @return
     */
    int deleteAnswerById(String answerId);

    /**
     * 查找指定id的回答
     * @param answerId
     * @return
     */
    Answer selectAnswerById(String answerId);

    /**
     * 查找用户所有回答
     * @param userId
     * @return
     */
    List<Answer> selectAnswerByUserId(String userId);

    /**
     * 该问题下所有的回答
     * @param questionId
     * @return
     */
    List<Answer> selectAnswerByQuestionId(String questionId);

    /**
     * 访问者点赞
     * @param answerId
     * @return
     */
    int likeAnswer(String answerId);

    /**
     * 文章的锁定
     * @param answerId
     * @param lock
     * @return
     */
    int answerLock(@Param("answerId") String answerId,
                   @Param("answerLock")int lock);

    /**
     * 获取指定回答的锁
     * @param answerId
     * @return
     */
    int getAnswerLock(String answerId);
}
