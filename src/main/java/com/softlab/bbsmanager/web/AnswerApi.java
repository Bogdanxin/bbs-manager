package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.common.util.JsonUtil;
import com.softlab.bbsmanager.common.util.VerifyUtil;
import com.softlab.bbsmanager.core.model.Answer;
import com.softlab.bbsmanager.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.image.BandedSampleModel;

/**
 * @ClassName AnswerApi
 * @Description answer web层
 * @Author gwx
 * @Date 2020/2/24 15:29
 * @Version 1.0
 */
@RestController
public class AnswerApi {

    private final static int BOARD_MASTER = 3;
    private final static Logger logger = LoggerFactory.getLogger(AnswerApi.class);
    private final AnswerService answerService;

    @Autowired
    public AnswerApi(AnswerService answerService) {
        this.answerService = answerService;
    }

    @RequestMapping(value = "/getAnswersByUserId/{id}",method = RequestMethod.GET)
    RestData getAnswersByUserId(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("get answers by user id: "+id);
//        if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
//            return new RestData(1,"用户未授权！");
//        }

        try {
            return new RestData(answerService.selectAnswerByUserId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getAnswersByQuestion/{id}",method = RequestMethod.GET)
    RestData getAnswersByQuestionId(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("get answers by question id: "+id);
       /* if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*/

        try {
            return new RestData(answerService.selectAnswerByQuestionId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getAnswersById/{id}",method = RequestMethod.GET)
    RestData getAllAnswers(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("get answers by id: "+id);
//        if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
//            return new RestData(1,"用户未授权！");
//        }

        try {
            return new RestData(answerService.selectAnswerById(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/updateAnswer/{id}", method = RequestMethod.POST)
    RestData updateAnswer(@RequestBody Answer answer, @PathVariable String id){
        logger.info("update answer: " + JsonUtil.getJsonFromObj(answer));

        try {
            return answerService.updateAnswer(answer, id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteAnswerById/{id}", method = RequestMethod.DELETE)
    RestData deleteAnswerById( @PathVariable String id/*, HttpServletRequest request*/){
        logger.info("delete answer by id : "+ id);

        /*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*/
        try {
            return answerService.deleteAnswerById(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/insertAnswer", method = RequestMethod.POST)
    RestData insertAnswer(@RequestBody Answer answer){
        logger.info("insert answer: " + JsonUtil.getJsonFromObj(answer));

        try {
            return answerService.insertAnswer(answer);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/likeAnswer/{id}", method = RequestMethod.POST)
    public RestData likeAnswer(@PathVariable String id){
        logger.info("like this answer by id : "+id);

        try {
            return answerService.likeAnswer(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }
}
