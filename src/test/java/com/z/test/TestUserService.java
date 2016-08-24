package com.z.test;

import com.z.model.Buser;
import com.z.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class TestUserService extends AbstractJUnit4SpringContextTests {

    @Resource
    private UserService userService;
    @Test
    public void TgetUserById(){
        Buser user = userService.getUserById(1);
        System.out.println(user.getName());
    }

    @Test
    public void TgetUserByName(){
        Buser user = userService.getUserByName("zhongxin");
        System.out.println(user.getNickname());
    }

    @Test
    public void Tsave(){
        Buser buser = new Buser();
        buser.setName("zhixiao");
        buser.setPassword("123");
        userService.save(buser);
    }
    @Test
    public void Tregister(){
        Buser buser = new Buser("Gary","1445");
        userService.register(buser);
    }
    @Test
    public void Tlogin(){
        Buser buser = new Buser("Gary","144");
        int i = userService.login(buser);
        System.out.println(i);
    }


}
