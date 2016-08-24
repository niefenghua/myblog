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

    private int currentPage;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String showAllArticle(){
        Page page = new Page();
        page.setPageSize(4);
        page.setCurrentPage(currentPage);
        Result result = articleService.queryAllByPage(page);
        ActionContext.getContext().put("result",result);

        return "success";
    }


}
