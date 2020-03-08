package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName Question
 * @Description question实体类
 * @Author gwx
 * @Date 2020/2/26 18:27
 * @Version 1.0
 */
@Data
public class Question {
    /**
     * 问题的唯一 id
     * 以 que开头
     */
    private String questionId;

    /**
     * 问题的对应的用户的 id
     */
    private String userId;

    /**
     * 问题的标题
     */
    private String questionTitle;

    /**
     * 问题文本存储路径
     */
    private String questionContent;

    /**
     * 问题对应的板块
     */
    private String boardId;

    /**
     * 问题创建时间
     */
    private String questionCreateTime;

    /**
     * 问题锁
     */
    private int questionLock;
}
