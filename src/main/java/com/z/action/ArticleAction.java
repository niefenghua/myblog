package com.z.action;

import com.opensymphony.xwork2.ActionContext;
import com.z.common.Page;
import com.z.common.Result;
import com.z.model.Barticle;
import com.z.model.Bcomments;
import com.z.model.Ctrs;
import com.z.service.ArticleService;
import com.z.service.CommentsService;
import com.z.service.CtrsService;
import com.z.service.UserService;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

public class ArticleAction {

    private ArticleService articleService;
    private CtrsService ctrsService;
    private CommentsService commentsService;
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public UserService getUserService() {
        return userService;
    }
    public void setCommentsService(CommentsService commentsService) {
        this.commentsService = commentsService;
    }
    public CommentsService getCommentsService() {
        return commentsService;
    }
    public void setCtrsService(CtrsService ctrsService) {
        this.ctrsService = ctrsService;
    }

    public CtrsService getCtrsService() {
        return ctrsService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    public ArticleService getArticleService() {
        return articleService;
    }

    private int aid;
    private int currentPage;
    private String comments;

    public void setComments(String comments) {
        this.comments = comments;
    }
    public String getComments() {
        return comments;
    }

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

        Barticle barticle = articleService.queryById(aid);

        ActionContext.getContext().put("barticle",barticle);

        // 进行点击量操作
        String ipaddress = ServletActionContext.getRequest().getRemoteAddr();
        System.out.println(ipaddress);

        Ctrs ctrs = new Ctrs();
        ctrs.setArticle(aid);
        ctrs.setDate(new Date());
        ctrs.setIpadress(ipaddress);
        ctrsService.save(ctrs);

        // 获取评论操作
        List<Bcomments> coms = commentsService.getCommentsByArticle(aid);
        ActionContext.getContext().put("coms",coms);


        return "success";
    }

    // 添加评论
    public String addComments(){
        Bcomments bcomments = new Bcomments();

        // 根据用户名获取uid
        String name = (String)ActionContext.getContext().getSession().get("username");
        int uid = userService.getUserByName(name).getUid();

        System.out.println(aid);

        bcomments.setArticle(aid);
        bcomments.setUser(uid);
        bcomments.setDate(new Date());
        bcomments.setContents(comments);
        commentsService.save(bcomments);

        return "success";
    }



}
