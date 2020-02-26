package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.mapper.ArticleMapper;
import com.softlab.bbsmanager.core.model.Article;
import com.softlab.bbsmanager.service.ArticleService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ArticleServiceImpl
 * @Description 实现ArticleService接口
 * @Author gwx
 * @Date 2020/2/26 10:18
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleMapper articleMapper;

    @Autowired
    public ArticleServiceImpl(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public RestData deleteArticleById(String articleId) throws BbsException {
        if (articleMapper.deleteArticleById(articleId) > 0) {
            return new RestData(0,"删除成功！");
        }else {
            throw new BbsException("删除失败！");
        }
    }

    @Override
    public RestData lockArticleById(String articleId, int lock) throws BbsException {
        if (articleMapper.lockArticleById(articleId, lock) > 0) {
            return (lock == 0)?
                    new RestData(0, "文章锁定成功！")
                    : new RestData(0, "文章解锁成功！");
        }else {
            throw (lock == 0)?
                    new BbsException( "文章锁定失败！")
                    : new BbsException("文章解锁失败！");
        }
    }

    @Override
    public RestData likeIt(String articleId) throws BbsException {
        if (articleMapper.likeIt(articleId) > 0) {
            return new RestData(0,"点赞成功！");
        }else {
            throw new BbsException("点赞失败！");
        }
    }

    @Override
    public Map<String, Object> selectArticleById(String articleId) throws BbsException {
        Article article = articleMapper.selectArticleById(articleId);
        Map<String, Object> map = null;
        if (article != null) {
            map = new HashMap<>(7);
            map.put("articleId", article.getArticleId());
            map.put("userId", article.getUserId());
            map.put("articleContent", article.getArticleContent());
            map.put("articleLikeNum", article.getArticleLikeNum());
            map.put("articleCreateTime", article.getArticleCreateTime());
            map.put("articleLock", article.getArticleLock());
        }else {
            throw new BbsException("查找失败！");
        }

        return map;
    }

    @Override
    public List<Map<String, Object>> selectArticleByUserId(String userId) throws BbsException {
        List<Article> articles = articleMapper.selectArticleByUserId(userId);
        List<Map<String, Object>> al = new ArrayList<>();
        if (articles != null) {
            for (Article article : articles){
                Map<String, Object> map = new HashMap<>();
                map.put("articleId", article.getArticleId());
                map.put("userId", article.getUserId());
                map.put("articleContent", article.getArticleContent());
                map.put("articleLikeNum", article.getArticleLikeNum());
                map.put("articleCreateTime", article.getArticleCreateTime());
                map.put("articleLock", article.getArticleLock());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }
        return al;
    }

    @Override
    public RestData insertArticle(Article article) throws BbsException {
        if (articleMapper.insertArticle(article) > 0) {
            return new RestData(0,"添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData updateArticleById(Article article, String articleId) throws BbsException {
        if (articleMapper.updateArticle(article, articleId) > 0) {
            return new RestData(0, "修改成功！");
        }else {
            throw new BbsException("修改失败！");
        }
    }
}
