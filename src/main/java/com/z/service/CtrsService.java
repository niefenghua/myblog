package com.z.service;

import com.z.model.Ctrs;

import java.util.List;

public interface CtrsService {


    void save(Ctrs ctrs);
    List<Ctrs> getCtrsByArticle(int aid);
    long getCountByArticle(int aid);
}
