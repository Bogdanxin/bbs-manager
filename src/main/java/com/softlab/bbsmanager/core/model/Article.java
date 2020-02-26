package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName Article
 * @Description 文章的实体类
 * @Author gwx
 * @Date 2020/2/26 9:21
 * @Version 1.0
 */
@Data
public class Article {

    /**
     * 文章的唯一 id
     * 以art开头
     */
    private String articleId;

    /**
     * 文章作者的 id
     */
    private String userId;

    /**
     * 文章内容以文本形式存储路径
     */
    private String articleContent;

    /**
     * 文章的点赞数
     */
    private Integer articleLikeNum;

    /**
     * 文章的题目
     */
    private String articleTitle;

    /**
     * 文章创建时间
     */
    private String articleCreateTime;

    /**
     * 文章锁定
     */
    private int articleLock;
}
