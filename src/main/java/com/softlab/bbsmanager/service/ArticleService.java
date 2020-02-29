package com.softlab.bbsmanager.service;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleService
 * @Description 文章的service层
 * @Author gwx
 * @Date 2020/2/26 10:08
 * @Version 1.0
 */
public interface ArticleService {

    /**
     * 删除指定id的文章
     * @param articleId
     * @return
     * @throws BbsException
     */
    RestData deleteArticleById(String articleId) throws BbsException;

    /**
     * 锁定指定id的文章
     * @param articleId
     * @param lock
     * @throws BbsException
     * @return
     */
    RestData lockArticleById(String articleId, int lock) throws BbsException;

    /**
     * 给指定id的文章点赞
     * @param articleId
     * @return
     * @throws BbsException
     */
    RestData likeArticle(String articleId) throws BbsException;

    /**
     * 查找指定id的文章
     * @param articleId
     * @return
     * @throws BbsException
     */
    Map<String, Object> selectArticleById(String articleId) throws BbsException;

    /**
     * 查找指定id的用户的所有文章
     * @param userId
     * @return
     * @throws BbsException
     */
    List<Map<String, Object>> selectArticleByUserId(String userId) throws BbsException;

    /**
     * 添加一个文章
     * @param article
     * @return
     * @throws BbsException
     */
    RestData insertArticle(Article article) throws BbsException;

    /**
     * 修改指定id的文章
     * @param article
     * @param articleId
     * @return
     * @throws BbsException
     */
    RestData updateArticleById(Article article, String articleId) throws BbsException;
}
