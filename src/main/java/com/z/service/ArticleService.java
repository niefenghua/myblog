package com.z.service;

import com.z.common.Page;
import com.z.common.Result;
import com.z.model.Barticle;

import java.util.List;

public interface ArticleService {

    // 保存文章
    void save(Barticle article);

    Barticle queryById(Integer id);

    // 查找所有
    List<Barticle> queryAll();
    Result queryAllByPage(Page page);


    // 根据作者查找全部
    List<Barticle> queryAllByUser(Integer uid);

    Result queryAllByUserPage(Integer uid,Page page);
    Result queryAllByUserPage(String name,Page page);
}
