package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName Comment
 * @Description 评论，可以有问题的评论也可以有
 * @Author gwx
 * @Date 2020/2/27 10:29
 * @Version 1.0
 */
@Data
public class Comment {
    /**
     * 评论的 id
     * 用c开头
     */
    private String commentId;

    /**
     * 评论对应的类型，
     * 0 = 回答 ans的评论，1 = 文章 art的评论 2 = 评论的评论
     */
    private int commentType;

    /**
     * 作为文章评论的 id
     */
    private String articleId;

    /**
     * 作为回答评论的id
     */
    private String answerId;

    /**
     * 评论文本的存储路径
     */
    private String commentContent;

    /**
     * 评论的点赞数
     */
    private int commentLikeNum;

    /**
     * 创建时间
     */
    private String commentCreateTime;

    /**
     * 对应的user的id
     */
    private String userId;

    /**
     * 评论的置顶
     */
    private int commentTop;

    /**
     * 对comment的评论，指向评论的评论
     */
    private String toCommentId;

    /**
     * 评论锁
     */
    private int commentLock;
}
