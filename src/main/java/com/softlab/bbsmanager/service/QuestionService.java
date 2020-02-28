package com.softlab.bbsmanager.service;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.model.Question;

import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionService
 * @Description 问题实体类
 * @Author gwx
 * @Date 2020/2/27 8:55
 * @Version 1.0
 */
public interface QuestionService {
    /**
     * 添加一个问题
     * @param question
     * @return
     */
    RestData insertQuestion(Question question) throws BbsException;

    /**
     * 修改问题
     * @param question
     * @param questionId
     * @return
     */
    RestData updateQuestion(Question question, String questionId) throws BbsException;

    /**
     * 删除指定id的问题
     * @param questionId
     * @return
     */
    RestData deleteQuestionById(String questionId) throws BbsException;

    /**
     * 锁定问题
     * @param questionId
     * @param lock
     * @return
     */
    RestData lockQuestionById(String questionId, int lock) throws BbsException;

    /**
     * 查找指定id用问题
     * @param questionId
     * @return
     */
    Map<String, Object> selectQuestionById(String questionId) throws BbsException;

    /**
     * 查找指定id的用户的所有问题
     * @param userId
     * @return
     */
    List<Map<String, Object>> selectQuestionByUserId(String userId) throws BbsException;
}
