package com.z.action;

import com.opensymphony.xwork2.ActionContext;
import com.z.common.Page;
import com.z.common.Result;
import com.z.model.Buser;
import com.z.service.ArticleService;
import com.z.service.UserService;
import org.apache.struts2.ServletActionContext;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import javax.servlet.Servlet;
import java.util.Map;

public class UserAction {

    private UserService userService;
    // 登录后需要显示用户所有文章
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public UserService getUserService() {
        return userService;
    }


    // 登陆和注册都需要这两个属性
    private String username;
    private String password;
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }


    // 登陆
    public String login(){
        // 登录成功后跳转到用户首页
        int isLogin = userService.login(username,password);
        if (isLogin==1){
            // 将用户名写入session
            ActionContext.getContext().getSession().put("username",username);
            return "success";
        }else
            return "error";

    }
    // 注册
    public String register(){
        // 注册成功后跳转到登陆界面
        int isOK = userService.register(username,password);
        if (isOK==1){
            return "success";
        }else
            return "error";

    }
}
