package com.softlab.bbsmanager.service;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.model.Comment;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;
import java.util.Map;

/**
 * @ClassName CommentService
 * @Description 评论的service层
 * @Author gwx
 * @Date 2020/2/27 15:24
 * @Version 1.0
 */
public interface CommentService {

    /**
     * 添加一个评论
     * @param commentType
     * @param comment
     * @param id
     * @return
     */
    RestData insertComment(int commentType, Comment comment, String id) throws BbsException;

    /**
     * 添加文章的评论
     * @param comment
     * @param articleId
     * @return
     */
    RestData insertArticleComment(Comment comment, String articleId) throws BbsException;

    /**
     * 添加回答的评论
     * @param comment
     * @param answerId
     * @return
     */
    RestData insertAnswerComment(Comment comment, String answerId) throws BbsException;

    /**
     * 添加一个对评论的评论
     * @param comment
     * @param toCommentId
     * @return
     */
    RestData insertCommentToComment(Comment comment, String toCommentId) throws BbsException;

    /**
     * 修改评论
     * @param comment
     * @param commentId
     * @return
     */
    RestData updateComment(Comment comment, String commentId) throws BbsException;

    /**
     * 删除指定id的评论
     * @param commentId
     * @return
     */
    RestData deleteCommentById(String commentId) throws BbsException;

    /**
     * 查找指定id的回答的所有评论
     * @param answerId
     * @return
     */
    List<Map<String, Object>> selectCommentByAnswerId(String answerId) throws BbsException;

    /**
     * 查找所有指定id评论下的所有评论
     * @param commentId
     * @return
     */
    List<Map<String, Object>> selectCommentByCommentId(String commentId) throws BbsException;

    /**
     * 查找所有指定id下文章的所有评论
     * @param articleId
     * @return
     */
    List<Map<String, Object>> selectCommentByArticleId(String articleId) throws BbsException;

    /**
     * 查找指定id的评论
     * @param commentId
     * @return
     */
    Map<String,Object> selectCommentById(String commentId) throws BbsException;
}
