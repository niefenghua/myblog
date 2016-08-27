package com.z.service;

import com.z.model.Ctrs;

import java.util.List;

public interface CtrsService {


    void save(Ctrs ctrs);
    List<Ctrs> getCtrsByArticle(int aid);
    int getCountByArticle(int aid);
    // 根据用户id获取总点击量
    int getCountByUser(int uid);
    int getCountByUserSQL(int uid);


}
