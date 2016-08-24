package com.z.dao;

import com.z.common.Page;
import com.z.model.Barticle;

import java.util.List;

public interface ArticleDao {

    // 保存文章
    void save(Barticle article);

    Barticle queryById(Integer id);

    // 查找所有
    List<Barticle> queryAll();

    List<Barticle> queryAllByPage(Page page);


    // 根据作者查找全部
    List<Barticle> queryAllByUser(Integer uid);

    List<Barticle> queryAllByUserPage(Integer uid,Page page);


}
