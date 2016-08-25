package com.z.action;

import com.opensymphony.xwork2.ActionContext;
import com.z.common.Page;
import com.z.common.Result;
import com.z.service.ArticleService;

public class ArticleActionUser {
    private ArticleService articleService;

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    int currentPage;

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public String showMyArticle(){
        Page page = new Page();
        page.setPageSize(3);
        page.setCurrentPage(currentPage);

        String name = (String) ActionContext.getContext().getSession().get("username");

        Result result = articleService.queryAllByUserPage(name,page);
        System.out.println(result.getList().size());
        ActionContext.getContext().put("result",result);

        return "success";
    }
}
