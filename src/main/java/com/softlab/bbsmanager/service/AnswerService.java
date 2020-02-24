package com.softlab.bbsmanager.service;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.model.Answer;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AnswerService
 * @Description answer service层
 * @Author gwx
 * @Date 2020/2/24 13:43
 * @Version 1.0
 */
public interface AnswerService {

    /**
     * 添加一个回答
     * @param answer
     * @return
     * @throws BbsException
     */
    RestData insertAnswer(Answer answer) throws BbsException;

    /**
     * 删除指定id的回答
     * @param answerId
     * @return
     * @throws BbsException
     */
    RestData deleteAnswerById(String answerId) throws BbsException;

    /**
     * 修改回答信息
     * @param answer
     * @param answerId
     * @return
     * @throws BbsException
     */
    RestData updateAnswer(Answer answer, String answerId) throws BbsException;

    /**
     * 查找指定id的
     * @param answerId
     * @return
     * @throws BbsException
     */
    Map<String, Object> selectAnswerById(String answerId) throws BbsException;

    /**
     * 查找指定id的用户所有的回答
     * @param userId
     * @return
     * @throws BbsException
     */
    List<Map<String, Object>> selectAnswerByUserId(String userId) throws BbsException;

    /**
     * 查找指定id的问题下所有的回答
     * @param questionId
     * @return
     * @throws BbsException
     */
    List<Map<String, Object>> selectAnswerByQuestionId(String questionId) throws BbsException;
}
