package com.z.action;

import com.z.model.Buser;
import com.z.service.UserService;

public class UserAction {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public String execute(){
       Buser user = userService.getUserById(1);
        System.out.println(user.getName());
        return "success";
    }
}
