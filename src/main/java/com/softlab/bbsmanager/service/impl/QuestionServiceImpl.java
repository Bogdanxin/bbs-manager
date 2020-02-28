package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.mapper.QuestionMapper;
import com.softlab.bbsmanager.core.model.Question;
import com.softlab.bbsmanager.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionServiceImpl
 * @Description question的service层操作
 * @Author gwx
 * @Date 2020/2/27 9:06
 * @Version 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;

    @Autowired
    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public RestData insertQuestion(Question question) throws BbsException {
        if (questionMapper.insertQuestion(question) < 0) {
            throw new BbsException("添加失败！");
        }else {
            return new RestData(0,"添加成功！");
        }
    }

    @Override
    public RestData updateQuestion(Question question, String questionId) throws BbsException {
        if (questionMapper.updateQuestion(question, questionId) > 0) {
            return new RestData(0,"修改成功！");
        }else {
            throw new BbsException("修改失败！");
        }
    }

    @Override
    public RestData deleteQuestionById(String questionId) throws BbsException {
        if (questionMapper.deleteQuestionById(questionId) > 0) {
            return new RestData(0, "删除成功！");
        }else {
            throw new BbsException("删除失败！");
        }
    }

    @Override
    public RestData lockQuestionById(String questionId, int lock) throws BbsException {
        if (questionMapper.lockQuestionById(questionId, lock) > 0) {
            return (lock == 1) ?
                    new RestData(0,"锁定成功！")
                    : new RestData(0,"解锁成功！");
        }else {
            throw (lock == 1) ? new BbsException("锁定失败！")
                    : new BbsException("解锁失败！");
        }
    }


    @Override
    public Map<String, Object> selectQuestionById(String questionId) throws BbsException {
        Map<String, Object> map = new HashMap<>();
        Question question = questionMapper.selectQuestionById(questionId);
        if (question != null) {
            map.put("questionId", question.getQuestionId());
            map.put("userId", question.getUserId());
            map.put("questionTitle",question.getQuestionTitle());
            map.put("questionContent", question.getQuestionContent());
            map.put("boardId", question.getBoardId());
            map.put("questionCreateTime", question.getQuestionCreateTime());
            map.put("lock",question.getLock());
        }else {
            throw new BbsException("查找失败！");
        }

        return map;
    }

    @Override
    public List<Map<String, Object>> selectQuestionByUserId(String userId) throws BbsException {
        List<Map<String, Object>> al = new ArrayList<>();
        List<Question> questions = questionMapper.selectQuestionByUserId(userId);
        if (questions != null) {
            for (Question question : questions){
                Map<String, Object> map = new HashMap<>();
                map.put("questionId", question.getQuestionId());
                map.put("userId", question.getUserId());
                map.put("questionTitle",question.getQuestionTitle());
                map.put("questionContent", question.getQuestionContent());
                map.put("boardId", question.getBoardId());
                map.put("questionCreateTime", question.getQuestionCreateTime());
                map.put("lock",question.getLock());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }

        return al;
    }
}
