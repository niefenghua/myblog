package com.z.action;

import com.opensymphony.xwork2.ActionContext;
import com.z.model.Barticle;
import com.z.service.ArticleService;
import com.z.service.UserService;

import java.util.Date;

public class ArticleActionSave {

    private ArticleService articleService;
    private UserService userService;
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    public ArticleService getArticleService() {
        return articleService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    private String title;
    private String content;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public String getTitle() {
        return title;
    }

    public String saveArticle(){

        Barticle barticle = new Barticle();
        barticle.setTitle(title);
        barticle.setContent(content);
        barticle.setDate(new Date());

        String name = (String)ActionContext.getContext().getSession().get("username");
        int uid = userService.getUserByName(name).getUid();

        barticle.setUser(uid);

        articleService.save(barticle);

        return "success";
    }
}
