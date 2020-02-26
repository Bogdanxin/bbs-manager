package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.common.util.JsonUtil;
import com.softlab.bbsmanager.common.util.VerifyUtil;
import com.softlab.bbsmanager.core.model.Board;
import com.softlab.bbsmanager.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName BoardApi
 * @Description board类的web层控制
 * @Author gwx
 * @Date 2020/2/26 16:22
 * @Version 1.0
 */
@RestController
public class BoardApi {

    private final static Logger logger = LoggerFactory.getLogger(BoardApi.class);
    private final BoardService boardService;
    private final static int BOARD_MASTER = 3;

    @Autowired
    public BoardApi(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
    public RestData insertBoard(@RequestBody Board board/*, HttpServletRequest request*/){
        logger.info("insert board :"+ JsonUtil.getJsonFromObj(board));

        /*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"添加失败！");
        }*/
        try {
            return boardService.insertBoard(board);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/deleteBoardById/{id}", method = RequestMethod.DELETE)
    public RestData deleteBoardById(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("delete board by id : " + id);
        /*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"删除失败！");
        }*/

        try {
            return boardService.deleteBoardById(id);
        }catch (BbsException b){
            return new RestData(1,b.getMessage());
        }
    }

    @RequestMapping(value = "/updateBoardById/{id}", method = RequestMethod.POST)
    public RestData updateBoardBy(@PathVariable String id, @RequestBody Board board){
        logger.info("update board: "+ JsonUtil.getJsonFromObj(board) +"by id :" + id);
        try {
            return boardService.updateBoard(board, id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getBoardById/{id}", method = RequestMethod.GET)
    public RestData getBoardById(@PathVariable String id){
        logger.info("get board by id : " + id);
        try {
            return new RestData(boardService.selectBoardById(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getBoardByMasterId/{id}", method = RequestMethod.GET)
    public RestData getBoardByMasterId(@PathVariable String id){
        logger.info("get board by master id :" + id);

        try {
            return new RestData(boardService.selectBoardByMasterId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }
}
