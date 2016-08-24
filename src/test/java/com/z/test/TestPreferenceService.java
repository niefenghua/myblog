package com.z.test;

import com.z.model.Preference;
import com.z.service.PreferenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-bean.xml")
public class TestPreferenceService extends AbstractJUnit4SpringContextTests {


    @Resource
    private PreferenceService preferenceService;

    @Test
    public void Tsave(){

        Preference pref = new Preference();
        pref.setUser(1);
        pref.setTitle("shndfi");
        pref.setSignature("sndfihf");

    }
    @Test
    public void TgetPreferenceById(){
        Preference pref = preferenceService.getPreferenceById(1);
        System.out.println(pref.getTitle());
        System.out.println(pref.getSignature());


    }
    @Test
    public void TgetPreferenceByUser(){
        Preference pref = preferenceService.getPreferenceByUser(2);
        System.out.println(pref.getTitle());
        System.out.println(pref.getSignature());
    }
    @Test
    public void TupdatePreference(){
        Preference pref = new Preference();
        pref.setTitle("abbb");
        pref.setSignature("acaca sknn");

        preferenceService.updatePreference("zhongxin",pref);

    }
}
