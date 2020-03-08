package com.softlab.bbsmanager.core.mapper;

import com.softlab.bbsmanager.core.model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName CommentMapper
 * @Description 对评论的数据库操作
 * @Author gwx
 * @Date 2020/2/27 10:31
 * @Version 1.0
 */
@Mapper
@Repository
public interface CommentMapper {

    /**
     * 根据不同的type添加
     * @param commentType
     * @param comment
     * @param id
     * @return
     */
    int insertComment(@Param("commentType") int commentType,
                      @Param("comment") Comment comment,
                      @Param("id") String id);

    /**
     * 添加一个文章的评论
     * @param comment
     * @param articleId
     * @return
     */
    int insertArticleComment(@Param("comment") Comment comment,
                             @Param("articleId") String articleId);

    /**
     * 添加一个回答的评论
     * @param comment
     * @param answerId
     * @return
     */
    int insertAnswerComment(@Param("comment") Comment comment,
                            @Param("answerId") String answerId);

    /**
     * 修改指定id的评论
     * @param comment
     * @param commentId
     * @return
     */
    int updateComment(@Param("comment") Comment comment,
                      @Param("commentId") String commentId);

    /*
     * 修改一个文章评论
     * @param comment
     * @param articleId
     * @return
     */
    /*    int updateArticleComment(@Param("comment") Comment comment,
                             @Param("articleId") String articleId);*/

    /*
     * 修改一个回答评论
     * @param comment
     * @param answerId
     * @return
     */

   /* int updateAnswerComment(@Param("comment") Comment comment,
                            @Param("answerId") String answerId);*/

    /**
     * 删除一个评论 用户和管理员都可以用这个
     * @param commentId
     * @return
     */
    int deleteCommentById(String commentId);

    /**
     * 对一个评论做评论
     * @param comment
     * @param toCommentId
     * @return
     */
    int insertCommentToComment(@Param("comment") Comment comment,
                               @Param("commentId") String toCommentId);

    /**
     * 修改一个对评论的评论
     * @param comment
     * @param commentId
     * @return
     *//*
    int updateCommentToComment(@Param("comment") Comment comment,
                               @Param("commentId") String commentId);*/

    /**
     * 查找指定id文章的所有回答
     * @param articleId
     * @return
     */
    List<Comment> selectCommentByArticleId(String articleId);

    /**
     * 查找指定id的回答的评论
     * @param answerId
     * @return
     */
    List<Comment> selectCommentByAnswerId(String answerId);

    /**
     * 查找指定id的comment的所有评论
     * @param toCommentId
     * @return
     */
    List<Comment> selectCommentByCommentId(String toCommentId);

    /**
     * 查找指定id的评论
     * @param commentId
     * @return
     */
    Comment selectCommentById(String commentId);

    /**
     * 锁定评论或者解锁评论
     * @param commentId
     * @param lock
     * @return
     */
    int lockComment(@Param("commentId") String commentId,
                    @Param("commentLock") int lock);

    /**
     * 获取指定评论的锁
     * @param commentId
     * @return
     */
    int getCommentLock(String commentId);
}

