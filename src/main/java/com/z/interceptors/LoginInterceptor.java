package com.z.interceptors;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        ActionContext context = invocation.getInvocationContext();
        String username = (String)context.getSession().get("username");
        if (username==null || "".equals(username)){
            return Action.INPUT;
        }else {
            return invocation.invoke();
        }

    }
}
