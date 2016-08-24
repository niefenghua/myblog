package com.z.service;

import com.z.common.Page;
import com.z.common.PageUtil;
import com.z.common.Result;
import com.z.dao.ArticleDao;
import com.z.model.Barticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    @Override
    public void save(Barticle article) {
        articleDao.save(article);
    }

    @Override
    public Barticle queryById(Integer id) {
        Barticle article = articleDao.queryById(id);
        return article;
    }

    @Override
    public List<Barticle> queryAll() {
        List<Barticle> barticles = articleDao.queryAll();
        return barticles;
    }

    @Override
    public Result queryAllByPage(Page page) {
        int count = articleDao.queryAll().size();
        page = PageUtil.createPage(page,count);

        List<Barticle> barticles = articleDao.queryAllByPage(page);

        Result result = new Result();
        result.setList(barticles);
        result.setPage(page);
        return result;
    }

    @Override
    public List<Barticle> queryAllByUser(Integer uid) {
        List<Barticle> barticles = articleDao.queryAllByUser(uid);
        return barticles;
    }

    @Override
    public Result queryAllByUserPage(Integer uid, Page page) {
        int count = articleDao.queryAllByUser(uid).size();
        page = PageUtil.createPage(page,count);

        List<Barticle> barticles = articleDao.queryAllByUserPage(uid,page);

        Result result = new Result();
        result.setList(barticles);
        result.setPage(page);
        return result;
    }



}
