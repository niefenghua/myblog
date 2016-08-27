package com.z.dao;

import com.z.model.Ctrs;

import java.util.List;

public interface CtrsDao {

    void save(Ctrs ctrs);
    List<Ctrs> getCtrsByArticle(int aid);
    int getCountByArticle(int aid);
    int getCountByArticleSQL(int aid);
}
