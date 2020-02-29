package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.mapper.AnswerMapper;
import com.softlab.bbsmanager.core.model.Answer;
import com.softlab.bbsmanager.core.model.User;
import com.softlab.bbsmanager.service.AnswerService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName AnswerService
 * @Description answer service层
 * @Author gwx
 * @Date 2020/2/24 13:43
 * @Version 1.0
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerMapper answerMapper;

    @Autowired
    public AnswerServiceImpl(AnswerMapper answerMapper) {
        this.answerMapper = answerMapper;
    }

    @Override
    public RestData insertAnswer(Answer answer) throws BbsException {
        if (answerMapper.insertAnswer(answer) > 0) {
            return new RestData(0,"添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData deleteAnswerById(String answerId) throws BbsException {
        if (answerMapper.deleteAnswerById(answerId) > 0) {
            return new RestData(0,"删除成功！");
        }else {
            throw new BbsException("删除失败！");
        }
    }

    @Override
    public RestData updateAnswer(Answer answer, String answerId) throws BbsException {
        if (answerMapper.updateAnswer(answer, answerId) > 0) {
            return new RestData(0, "修改成功！");
        }else {
            throw new BbsException("修改失败！");
        }
    }

    @Override
    public Map<String, Object> selectAnswerById(String answerId) throws BbsException {
        Map<String, Object> map = null;
        Answer answer = answerMapper.selectAnswerById(answerId);

        if (answer != null) {
            map = new HashMap<>();
            map.put("answerId", answer.getAnswerId());
            map.put("userId", answer.getUserId());
            map.put("answerContent", answer.getAnswerContent());
            map.put("boardId", answer.getBoardId());
            map.put("questionId", answer.getQuestionId());
            map.put("answerLikeNum", answer.getAnswerLikeNum());
            map.put("answerTop", answer.getAnswerTop());
            map.put("answerCreateTime", answer.getAnswerCreateTime());
        }else {
            throw new BbsException("查找失败！");
        }

        return map;
    }

    @Override
    public List<Map<String, Object>> selectAnswerByUserId(String userId) throws BbsException {
        List<Map<String, Object>> al = new ArrayList<>();
        List<Answer> answers = answerMapper.selectAnswerByUserId(userId);
        if (answers != null && answers.size() != 0) {
            for (Answer answer : answers){
                Map<String, Object> map = new HashMap<>();
                map.put("answerId", answer.getAnswerId());
                map.put("userId", answer.getUserId());
                map.put("answerContent", answer.getAnswerContent());
                map.put("boardId", answer.getBoardId());
                map.put("questionId", answer.getQuestionId());
                map.put("answerLikeNum", answer.getAnswerLikeNum());
                map.put("answerTop", answer.getAnswerTop());
                map.put("answerCreateTime", answer.getAnswerCreateTime());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }
        return al;
    }

    @Override
    public List<Map<String, Object>> selectAnswerByQuestionId(String questionId) throws BbsException {
        List<Map<String, Object>> al = new ArrayList<>();
        List<Answer> answers = answerMapper.selectAnswerByQuestionId(questionId);
        if (answers != null && answers.size() != 0) {
            for (Answer answer : answers){
                Map<String, Object> map = new HashMap<>();
                map.put("answerId", answer.getAnswerId());
                map.put("userId", answer.getUserId());
                map.put("answerContent", answer.getAnswerContent());
                map.put("boardId", answer.getBoardId());
                map.put("questionId", answer.getQuestionId());
                map.put("answerLikeNum", answer.getAnswerLikeNum());
                map.put("answerTop", answer.getAnswerTop());
                map.put("answerCreateTime", answer.getAnswerCreateTime());
            }
        }else {
            throw new BbsException("查找失败！");
        }
        return al;
    }

    @Override
    public RestData likeAnswer(String answerId) throws BbsException {
        if (answerMapper.likeAnswer(answerId) > 0) {
            return new RestData(0,"点赞成功！");
        }else {
            throw new BbsException("点赞失败！");
        }
    }
}
