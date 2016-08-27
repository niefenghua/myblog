package com.z.test;

import com.z.model.Ctrs;
import com.z.service.CtrsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class TestCtrsService {
    @Resource
    private CtrsService ctrsService;
    @Test
    public void TgetCtrsByArticle(){

        List<Ctrs> ctrsss = ctrsService.getCtrsByArticle(2);
        for(Ctrs ct:ctrsss){
            System.out.println(ct);
        }

    }
    @Test
    public void TgetCountByArticle(){
        System.out.println(ctrsService.getCountByArticle(2));

    }
    @Test
    public void Tsave(){
        Ctrs ct = new Ctrs();
        ct.setArticle(2);
        ct.setIpadress("127.12.34.7");
        ct.setDate(new Date());

        ctrsService.save(ct);
    }
    @Test
    public void TgetCountByUser(){
        int count = ctrsService.getCountByUser(1);
        System.out.println(count);
    }
    @Test
    public void TgetCountByUserSQL(){
        long count = ctrsService.getCountByUserSQL(1);
        System.out.println(count);
    }

}
