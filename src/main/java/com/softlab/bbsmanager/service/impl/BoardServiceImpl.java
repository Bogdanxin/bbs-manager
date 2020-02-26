package com.softlab.bbsmanager.service.impl;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.core.mapper.BoardMapper;
import com.softlab.bbsmanager.core.model.Board;
import com.softlab.bbsmanager.service.BoardService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BoardServiceImpl
 * @Description 实现BoardService接口
 * @Author gwx
 * @Date 2020/2/26 16:09
 * @Version 1.0
 */
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public RestData insertBoard(Board board) throws BbsException {
        if (boardMapper.insertBoard(board) > 0) {
            return new RestData(0,"添加成功！");
        }else {
            throw new BbsException("添加失败！");
        }
    }

    @Override
    public RestData deleteBoardById(String boardId) throws BbsException {
        if (boardMapper.deleteBoardById(boardId) > 0) {
            return new RestData(0,"删除成功!");
        }else {
            throw new BbsException("删除失败!");
        }
    }

    @Override
    public RestData updateBoard(Board board, String boardId) throws BbsException {
        if (boardMapper.updateBoard(board, boardId) > 0) {
            return new RestData(0,"修改成功！");
        }else {
            throw new BbsException("修改失败！");
        }
    }

    @Override
    public Map<String, Object> selectBoardById(String boardId) throws BbsException {
        Map<String, Object> map = new HashMap<>(5);
        Board board = boardMapper.selectBoardById(boardId);
        if (board != null) {
            map.put("boardId", board.getBoardId());
            map.put("boardName", board.getBoardName());
            map.put("boardMasterId", board.getBoardMasterId());
            map.put("boardCreateTime", board.getBoardCreateTime());
            map.put("boardIntroduction", board.getBoardIntroduction());
        }else {
            throw new BbsException("查找失败！");
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> selectBoardByMasterId(String boardMasterId) throws BbsException {
        List<Map<String,Object>> al = new ArrayList<>();
        List<Board> boards = boardMapper.selectBoardByMasterId(boardMasterId);
        if (boards != null) {
            for (Board board : boards){
                Map<String, Object> map = new HashMap<>(5);
                map.put("boardId", board.getBoardId());
                map.put("boardName", board.getBoardName());
                map.put("boardMasterId", board.getBoardMasterId());
                map.put("boardCreateTime", board.getBoardCreateTime());
                map.put("boardIntroduction", board.getBoardIntroduction());
                al.add(map);
            }
        }else {
            throw new BbsException("查找失败！");
        }

        return al;
    }

}
