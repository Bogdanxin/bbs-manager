package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.common.util.JsonUtil;
import com.softlab.bbsmanager.common.util.VerifyUtil;
import com.softlab.bbsmanager.core.model.Comment;
import com.softlab.bbsmanager.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CommentApi
 * @Description 评论的web层
 * @Author gwx
 * @Date 2020/2/28 9:03
 * @Version 1.0
 */
@RestController
public class CommentApi {

    private final static Logger logger = LoggerFactory.getLogger(CommentApi.class);
    private final CommentService commentService;
    private final static int BOARD_MASTER = 3;

    @Autowired
    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    /*@RequestMapping(value = "/insertComment/{id}", method = RequestMethod.POST)
    public RestData insertComment(@PathVariable String id,
                                  @RequestParam("commentType") int commentType,
                                  @RequestBody )*/

    @RequestMapping(value = "/insertArticleComment/{id}", method = RequestMethod.POST)
    public RestData insertArticleComment(@PathVariable String id,
                                         @RequestBody Comment comment){
        logger.info("insert article comment: "+ JsonUtil.getJsonFromObj(comment)
                + " by id : " + id);
        try {
            return commentService.insertArticleComment(comment, id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/insertAnswerComment/{id}", method = RequestMethod.POST)
    public RestData insertAnswerComment(@PathVariable String id,
                                        @RequestBody Comment comment){
        logger.info("insert answer comment: " + JsonUtil.getJsonFromObj(comment) + "by id: "+ id);

        try {
            return commentService.insertAnswerComment(comment, id);
        }catch (BbsException e){
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/insertCommentToComment/{id}", method = RequestMethod.POST)
    public RestData insertCommentToComment(@PathVariable String id,
                                           @RequestBody Comment comment){
        logger.info("insert answer comment : " + JsonUtil.getJsonFromObj(comment)
                + " by id : " + id);

        try {
            return commentService.insertCommentToComment(comment, id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/updateComment/{id}", method = RequestMethod.POST)
    public RestData updateComment(@PathVariable String id, @RequestBody Comment comment){
        logger.info("update comment : " + JsonUtil.getJsonFromObj(comment));

        try {
            return commentService.updateComment(comment, id);
        }catch (BbsException e){
            return new RestData(1, e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteCommentById/{id}", method = RequestMethod.DELETE)
    public RestData deleteCommentById(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("delete comment by id : " + id);
/*
        if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*/
        try {
            return commentService.deleteCommentById(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getCommentByAnswerId/{id}", method = RequestMethod.GET)
    public RestData getCommentByAnswerId(@PathVariable String id){
        logger.info("get comment by answer id : " + id);

        try {
            return new RestData( commentService.selectCommentByAnswerId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getCommentByArticleId/{id}", method = RequestMethod.GET)
    public RestData getCommentByArticleId(@PathVariable String id){
        logger.info("get comment by article id : " + id);

        try {
            return new RestData( commentService.selectCommentByArticleId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getCommentByCommentId/{id}", method = RequestMethod.GET)
    public RestData getCommentByCommentId(@PathVariable String id){
        logger.info("get comment by toComment id : " + id);

        try {
            return new RestData( commentService.selectCommentByCommentId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getCommentById/{id}", method = RequestMethod.GET)
    public RestData getCommentById(@PathVariable String id){
        logger.info("get comment by id : " + id);

        try {
            return new RestData( commentService.selectCommentById(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

}
