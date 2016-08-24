package com.z.test;

import com.z.common.Page;
import com.z.common.Result;
import com.z.model.Barticle;
import com.z.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class TestArticleService extends AbstractJUnit4SpringContextTests {

    @Resource
    private ArticleService articleService;

    @Test
    public void Tsave(){
        Barticle barticle = new Barticle();
        barticle.setTitle("奥运闭幕");
        barticle.setUser(1);
        barticle.setContent("sndsg snkodfnaobdg sdg");
        barticle.setDate(new Date());
        articleService.save(barticle);
    }

    @Test
    public void TqueryById(){
       Barticle art = articleService.queryById(6);
        System.out.println(art);
    }

    @Test
    public void TqueryAll(){
        List<Barticle> all = articleService.queryAll();
        System.out.println(all.size());
    }
    @Test
    public void TqueryAllByPage(){
        Page page = new Page();
        page.setCurrentPage(1);
        page.setPageSize(3);

        Result result = articleService.queryAllByPage(page);
        List<Barticle> all = result.getList();
        for(Barticle art: all){
            System.out.println(art.toString());
        }

    }

    @Test
    public void TqueryAllByUser(){

        List<Barticle> ual = articleService.queryAllByUser(2);
        for(Barticle art: ual){
            System.out.println(art.toString());
        }

    }

    @Test
    public void TqueryAllByUserPage(){
        Page page = new Page();
        page.setPageSize(3);
        page.setCurrentPage(2);

        Result result = articleService.queryAllByUserPage(1,page);
        List<Barticle> all = result.getList();
        for(Barticle art: all){
            System.out.println(art.toString());
        }
    }

}
