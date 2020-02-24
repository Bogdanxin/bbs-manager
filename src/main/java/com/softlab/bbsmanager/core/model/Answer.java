package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName Answer
 * @Description 回答实体类
 * @Author gwx
 * @Date 2020/2/22 17:39
 * @Version 1.0
 */
@Data
public class Answer {

    /**
     * 回答的唯一 id
     * 以ans开头
     */
    private String answerId;

    /**
     * 回答问题的 user id
     */
    private String userId;

    /**
     * 回答作为文本 存放的路径
     */
    private String answerContent;

    /**
     * 回答的相关的板块 id
     */
    private String boardId;

    /**
     * 回答的问题的 id
     */
    private String questionId;

    /**
     * 回答的点赞数
     */
    private Integer answerLikeNum;

    /**
     * 置顶帖 0 = 普通帖 ，1 = 置顶帖
     */
    private Integer answerTop;

    /**
     * 创建时间 用字符串在Java中，
     * 传入到数据库中就是datetime类型
     */
    private String answerCreateTime;
}
