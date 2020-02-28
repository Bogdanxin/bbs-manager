package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.mapper.CommentMapper;
import com.softlab.bbsmanager.core.model.Comment;
import com.softlab.bbsmanager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommentServiceImpl
 * @Description comment service层
 * @Author gwx
 * @Date 2020/2/27 19:35
 * @Version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public RestData insertComment(int commentType, Comment comment, String id) throws BbsException {
        if (commentMapper.insertComment(commentType, comment, id) > 0) {
            return new RestData(0,"添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData insertArticleComment(Comment comment, String articleId) throws BbsException {
        if (commentMapper.insertArticleComment(comment, articleId) > 0){
            return new RestData(0,"添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData insertAnswerComment(Comment comment, String answerId) throws BbsException {
        if (commentMapper.insertAnswerComment(comment, answerId) > 0) {
            return new RestData(0, "添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData insertCommentToComment(Comment comment, String toCommentId) throws BbsException {
        if (commentMapper.insertCommentToComment(comment, toCommentId) > 0) {
            return new RestData(0, "添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData updateComment(Comment comment, String commentId) throws BbsException {
        if (commentMapper.updateComment(comment, commentId) > 0) {
            return new RestData(0, "修改成功！");
        }else {
            throw new BbsException("修改失败！");
        }
    }

    @Override
    public RestData deleteCommentById(String commentId) throws BbsException {
        if (commentMapper.deleteCommentById(commentId) > 0) {
            return new RestData(0, "删除成功！");
        }else {
            throw new BbsException("删除失败！");
        }
    }

    @Override
    public List<Map<String, Object>> selectCommentByAnswerId(String answerId) throws BbsException {
        List<Map<String, Object>> al = new ArrayList<>();
        List<Comment> comments = commentMapper.selectCommentByAnswerId(answerId);
        if (comments != null){
            for (Comment comment : comments){
                Map<String, Object> map = new HashMap<>();
                map.put("commentId", comment.getCommentId());
                map.put("commentType", comment.getCommentType());
                map.put("articleId", comment.getArticleId());
                map.put("answerId", comment.getAnswerId());
                map.put("commentContent", comment.getCommentContent());
                map.put("commentLikeNum", comment.getCommentLikeNum());
                map.put("userId", comment.getUserId());
                map.put("commentTop", comment.getCommentTop());
                map.put("toCommentId", comment.getToCommentId());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }

        return al;
    }

    @Override
    public List<Map<String, Object>> selectCommentByCommentId(String commentId) throws BbsException {
        List<Map<String, Object>> al = new ArrayList<>();
        List<Comment> comments = commentMapper.selectCommentByCommentId(commentId);
        if (comments != null){
            for (Comment comment : comments){
                Map<String, Object> map = new HashMap<>();
                map.put("commentId", comment.getCommentId());
                map.put("commentType", comment.getCommentType());
                map.put("articleId", comment.getArticleId());
                map.put("answerId", comment.getAnswerId());
                map.put("commentContent", comment.getCommentContent());
                map.put("commentLikeNum", comment.getCommentLikeNum());
                map.put("userId", comment.getUserId());
                map.put("commentTop", comment.getCommentTop());
                map.put("toCommentId", comment.getToCommentId());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }

        return al;
    }

    @Override
    public List<Map<String, Object>> selectCommentByArticleId(String articleId) throws BbsException {
        List<Map<String, Object>> al = new ArrayList<>();
        List<Comment> comments = commentMapper.selectCommentByArticleId(articleId);
        if (comments != null){
            for (Comment comment : comments){
                Map<String, Object> map = new HashMap<>();
                map.put("commentId", comment.getCommentId());
                map.put("commentType", comment.getCommentType());
                map.put("articleId", comment.getArticleId());
                map.put("answerId", comment.getAnswerId());
                map.put("commentContent", comment.getCommentContent());
                map.put("commentLikeNum", comment.getCommentLikeNum());
                map.put("userId", comment.getUserId());
                map.put("commentTop", comment.getCommentTop());
                map.put("toCommentId", comment.getToCommentId());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }

        return al;
    }

    @Override
    public Map<String, Object> selectCommentById(String commentId) throws BbsException {
        Map<String, Object> map = new HashMap<>();
        Comment comment = commentMapper.selectCommentById(commentId);
        if (comment != null) {
            map.put("commentId", comment.getCommentId());
            map.put("commentType", comment.getCommentType());
            map.put("articleId", comment.getArticleId());
            map.put("answerId", comment.getAnswerId());
            map.put("commentContent", comment.getCommentContent());
            map.put("commentLikeNum", comment.getCommentLikeNum());
            map.put("userId", comment.getUserId());
            map.put("commentTop", comment.getCommentTop());
            map.put("toCommentId", comment.getToCommentId());
        }else {
            throw new BbsException("查找失败！");
        }

        return map;
    }
}
