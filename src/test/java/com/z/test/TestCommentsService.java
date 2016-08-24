package com.z.test;

import com.z.model.Bcomments;
import com.z.service.CommentsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class TestCommentsService {

    @Resource
    private CommentsService commentsService;

    @Test
    public void Tsave(){
        Bcomments bcomments =new Bcomments();
        bcomments.setArticle(2);
        bcomments.setUser(1);
        bcomments.setContents("hao wenzhang ；楼主给力");
        bcomments.setDate(new Date());

        commentsService.save(bcomments);
    }
    @Test
    public void TgetCommentsByArticle(){

        List<Bcomments> comments = commentsService.getCommentsByArticle(2);
        for(Bcomments bc:comments){
            System.out.println(bc);
        }

    }
    @Test
    public void TdeleteById(){
        commentsService.deleteById(2);
    }
}
