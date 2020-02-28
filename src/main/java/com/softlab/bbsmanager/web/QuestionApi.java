package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.common.util.JsonUtil;
import com.softlab.bbsmanager.common.util.VerifyUtil;
import com.softlab.bbsmanager.core.model.Question;
import com.softlab.bbsmanager.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName QuestionApi
 * @Description 问题的web层
 * @Author gwx
 * @Date 2020/2/27 9:19
 * @Version 1.0
 */
@RestController
public class QuestionApi {

    private final static Logger logger = LoggerFactory.getLogger(QuestionApi.class);
    private final QuestionService questionService;
    private final static int BOARD_MASTER = 3;

    @Autowired
    public QuestionApi(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(value = "/insertQuestion", method = RequestMethod.POST)
    public RestData insertQuestion(@RequestBody Question question){
        logger.info("insert question :"+ JsonUtil.getJsonFromObj(question));

        try {
            return questionService.insertQuestion(question);
        }catch (BbsException b){
            return new RestData(1,b.getMessage());
        }
    }

    @RequestMapping(value = "/updateQuestion/{id}", method = RequestMethod.POST)
    public RestData updateQuestion(@PathVariable String id,@RequestBody Question question){
        logger.info("update question :"+ JsonUtil.getJsonFromObj(question) + "by id : "+id);

        try {
            return questionService.updateQuestion(question,id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteQuestionById/{id}", method = RequestMethod.DELETE)
    public RestData deleteQuestion(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("delete question by id : "+id);
/*
        if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"删除失败");
        }*/
        try {
            return questionService.deleteQuestionById(id);
        }catch (BbsException b){
            return new RestData(1,b.getMessage());
        }
    }

    @RequestMapping(value = "/getQuestionById/{id}", method = RequestMethod.GET)
    public RestData getQuestionById(@PathVariable String id){
        logger.info("get question by id :" + id);
        try {
            return new RestData(questionService.selectQuestionById(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getQuestionByUserId/{id}", method = RequestMethod.GET)
    public RestData getQuestionByUserId(@PathVariable String id){
        logger.info("get question by user id :" + id);
        try {
            return new RestData(questionService.selectQuestionByUserId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }


}
