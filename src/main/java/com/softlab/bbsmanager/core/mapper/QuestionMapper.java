package com.softlab.bbsmanager.core.mapper;

import com.softlab.bbsmanager.core.model.Question;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName QuestionMapper
 * @Description 对问题的数据库操作
 * @Author gwx
 * @Date 2020/2/26 18:33
 * @Version 1.0
 */
@Mapper
@Repository
public interface QuestionMapper {

    /**
     * 添加一个问题
     * @param question
     * @return
     */
    int insertQuestion(Question question);

    /**
     * 修改一个问题
     * @param question
     * @param questionId
     * @return
     */
    int updateQuestion(@Param("question") Question question,
                       @Param("questionId") String questionId);

    /**
     * 删除指定id的问题
     * @param id
     * @return
     */
    int deleteQuestionById(String id);

    /**
     * 锁定或解锁一个问题
     * @param questionId
     * @param lock
     * @return
     */
    int lockQuestionById(@Param("questionId") String questionId,
                         @Param("questionLock") int lock);

    /**
     * 查找指定id的问题
     * @param questionId
     * @return
     */
    Question selectQuestionById(String questionId);

    /**
     * 查找指定id的用户的所有问题
     * @param userId
     * @return
     */
    List<Question> selectQuestionByUserId(String userId);

    /**
     * 查找指定id的板块下的所有问题
     * @param boardId
     * @return
     */
    List<Question> selectQuestionByBoardId(String boardId);

    /**
     * 获取指定id的问题的lock
     * @param questionId
     * @return
     */
    int getQuestionLock(String questionId);
}
