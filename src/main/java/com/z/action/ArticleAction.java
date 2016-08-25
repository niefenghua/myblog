package com.z.action;

import com.opensymphony.xwork2.ActionContext;
import com.z.common.Page;
import com.z.common.Result;
import com.z.model.Barticle;
import com.z.service.ArticleService;

import java.util.List;

public class ArticleAction {

    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    private int aid;
    private int currentPage;

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAid() {
        return aid;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String showAllArticle(){
        Page page = new Page();
        page.setPageSize(3);
        page.setCurrentPage(currentPage);
        Result result = articleService.queryAllByPage(page);
        ActionContext.getContext().put("result",result);

        return "success";
    }

    public String showArticle(){
        System.out.println(aid);
        Barticle barticle = articleService.queryById(aid);

        ActionContext.getContext().put("barticle",barticle);

        return "success";
    }

    public String saveArticle(){


        return "success";
    }


}
