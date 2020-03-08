package com.softlab.bbsmanager.core.mapper;

import com.softlab.bbsmanager.core.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description 文章对数据库操作
 * @Author gwx
 * @Date 2020/2/26 9:21
 * @Version 1.0
 */
@Mapper
@Repository
public interface ArticleMapper {

    /**
     * 删除指定id的文章
     * @param articleId
     * @return
     */
    int deleteArticleById(String articleId);

    /**
     * 锁定指定id的文章
     * @param articleId
     * @param lock
     * @return
     */
    int lockArticleById(@Param("articleId") String articleId,
                        @Param("articleLock")int lock);

    /**
     * 访问者点赞
     * @param articleId
     * @return
     */
    int likeArticle(String articleId);

    /**
     * 添加一个article
     * @param article
     * @return
     */
    int insertArticle(Article article);

    /**
     * 修改一个article
     * @param article
     * @param articleId
     * @return
     */
    int updateArticle(@Param("article") Article article,
                      @Param("articleId") String articleId);

    /**
     * 查找指定id的文章
     * @param articleId
     * @return
     */
    Article selectArticleById(String articleId);

    /**
     * 查找指定user的所有文章
     * @param userId
     * @return
     */
    List<Article> selectArticleByUserId(String userId);

    /**
     * 获取指定文章的锁
     * @param articleId
     * @return
     */
    int getArticleLock(String articleId);
}
