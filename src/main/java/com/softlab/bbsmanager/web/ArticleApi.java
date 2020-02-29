package com.softlab.bbsmanager.web;

import com.softlab.bbsmanager.common.BbsException;
import com.softlab.bbsmanager.common.RestData;
import com.softlab.bbsmanager.common.util.JsonUtil;
import com.softlab.bbsmanager.common.util.VerifyUtil;
import com.softlab.bbsmanager.core.model.Article;
import com.softlab.bbsmanager.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ArticleApi
 * @Description 文章的web层操作
 * @Author gwx
 * @Date 2020/2/26 10:39
 * @Version 1.0
 */
@RestController
public class ArticleApi {

    private final static Logger logger = LoggerFactory.getLogger(ArticleApi.class);
    private final ArticleService articleService;
    private final static int BOARD_MASTER = 3;

    @Autowired
    public ArticleApi(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/deleteArticleById/{id}", method = RequestMethod.DELETE)
    public RestData deleteArticleById(@PathVariable String id/*, HttpServletRequest request*/){
        logger.info("delete article by id: "+id);
     /*   if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*/
        try {
            return articleService.deleteArticleById(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    /*@RequestMapping(value = "/lockArticle/{id}", method = RequestMethod.POST)
    public RestData lockArticleById(@PathVariable String id*//*, HttpServletRequest request*//*,
                                    @RequestParam("lock") int lock){
        logger.info("lock article by id: "+id);

        *//*if (VerifyUtil.verifyUserType(request) != BOARD_MASTER) {
            return new RestData(1,"用户未授权！");
        }*//*
        try {
            return articleService.lockArticleById(id, lock);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }*/

    @RequestMapping(value = "/likeArticle/{id}", method = RequestMethod.POST)
    public RestData likeArticle(@PathVariable String id){
        logger.info("like it id :" +id);

        try {
            return articleService.likeArticle(id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/getArticleById/{id}", method = RequestMethod.GET)
    public RestData getArticleById(@PathVariable String id){
        logger.info("get article by id: " + id);

        try {
            return new RestData(articleService.selectArticleById(id));
        }catch (BbsException b){
            return new RestData(1,b.getMessage());
        }
    }

    @RequestMapping(value = "/getArticlesByUserId/{id}", method = RequestMethod.GET)
    public RestData getArticleByUserId(@PathVariable String id){
        logger.info("get article by user id: " + id);

        try {
            return new RestData(articleService.selectArticleByUserId(id));
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    /**
     * 使用@RequestBody时，要用到json传入参数，json形式要有注意
     * 键值都要用引号如：{"articleId":"art1"}
     * @param article
     * @return
     */
    @RequestMapping(value = "/insertArticle", method = RequestMethod.POST)
    public RestData insertArticle(@RequestBody Article article){
        logger.info("insert article :" + JsonUtil.getJsonFromObj(article));

        try {
            return articleService.insertArticle(article);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }

    @RequestMapping(value = "/updateArticleById/{id}", method = RequestMethod.POST)
    public RestData updateArticleById(@PathVariable String id, @RequestBody Article article){
        logger.info("update article: " + JsonUtil.getJsonFromObj(article) + " by id: " + id);

        try {
            return articleService.updateArticleById(article, id);
        }catch (BbsException e){
            return new RestData(1,e.getMessage());
        }
    }
}
