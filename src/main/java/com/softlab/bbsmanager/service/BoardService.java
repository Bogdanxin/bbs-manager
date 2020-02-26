package com.softlab.bbsmanager.service;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.model.Board;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName BoardService
 * @Description service层board
 * @Author gwx
 * @Date 2020/2/26 15:16
 * @Version 1.0
 */
public interface BoardService {
    /**
     * 添加一个board
     * @param board
     * @return
     * @throws BbsException
     */
    RestData insertBoard(Board board) throws BbsException;

    /**
     * 删除指定id的板块
     * @param boardId
     * @return
     * @throws BbsException
     */
    RestData deleteBoardById(String boardId) throws BbsException;

    /**
     * 修改指定id的板块
     * @param board
     * @param boardId
     * @return
     * @throws BbsException
     */
    RestData updateBoard(@Param("board")Board board,
                         @Param("boardId") String boardId) throws BbsException;

    /**
     * 查找指定id的板块
     * @param boardId
     * @return
     * @throws BbsException
     */
    Map<String, Object> selectBoardById(String boardId) throws BbsException;

    /**
     * 查找指定版主的所有板块
     * @param boardMasterId
     * @return
     * @throws BbsException
     */
    List<Map<String, Object>> selectBoardByMasterId(String boardMasterId) throws BbsException;
}
