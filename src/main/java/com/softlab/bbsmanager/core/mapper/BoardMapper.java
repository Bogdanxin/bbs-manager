package com.softlab.bbsmanager.core.mapper;

import com.softlab.bbsmanager.core.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName BoardMapper
 * @Description 板块对数据库操作类
 * @Author gwx
 * @Date 2020/2/26 14:30
 * @Version 1.0
 */

@Mapper
@Repository
public interface BoardMapper {

    /**
     * 添加一个board
     * @param board
     * @return
     */
    int insertBoard(Board board);

    /**
     * 删除指定id的板块
     * @param boardId
     * @return
     */
    int deleteBoardById(String boardId);

    /**
     * 修改指定id的板块
     * @param board
     * @param boardId
     * @return
     */
    int updateBoard(@Param("board") Board board,
                    @Param("boardId") String boardId);

    /**
     * 根据版主id查找所有的板块
     * @param masterId
     * @return
     */
    List<Board> selectBoardByMasterId(String masterId);

    /**
     * 查找指定id的板块
     * @param boardId
     * @return
     */
    Board selectBoardById(String boardId);
}
