package com.softlab.bbsmanager.core.model;

import lombok.Data;

/**
 * @ClassName Board
 * @Description 板块类
 * @Author gwx
 * @Date 2020/2/26 14:28
 * @Version 1.0
 */
@Data
public class Board {
    /**
     * 板块的 id
     * 用b开头
     */
    private String boardId;

    /**
     * 板块的名字
     */
    private String boardName;

    /**
     * 板块版主的 id
     */
    private String boardMasterId;

    /**
     * 板块介绍文本的存储路径
     */
    private String boardIntroduction;

    /**
     * 板块创建时间
     */
    private String boardCreateTime;
}
