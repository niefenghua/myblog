package com.z.service;

import com.z.dao.ArticleDao;
import com.z.dao.CtrsDao;
import com.z.model.Barticle;
import com.z.model.Ctrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("ctrsService")
public class CtrsServiceImpl implements CtrsService {

    @Autowired
    private CtrsDao ctrsDao;
    @Autowired
    private ArticleDao articleDao;

    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    public ArticleDao getArticleDao() {
        return articleDao;
    }
    public void setCtrsDao(CtrsDao ctrsDao) {
        this.ctrsDao = ctrsDao;
    }
    public CtrsDao getCtrsDao() {
        return ctrsDao;
    }
    @Override
    public void save(Ctrs ctrs) {
        // 根据传进来的Ctrs的article id 查出所有ctrs
        List<Ctrs> ctss = getCtrsByArticle(ctrs.getArticle());
        // 遍历ctrs，取出所有ip地址，再和传入的ip对比
        List<String> ipaddr = new ArrayList<>();
        for (Ctrs ct:ctss){
            ipaddr.add(ct.getIpadress());
        }
        if (!(ipaddr.contains(ctrs.getIpadress()))){
            // ip不同，存入数据库，相同的话不做插入操作
            ctrsDao.save(ctrs);
        }


    }

    @Override
    public List<Ctrs> getCtrsByArticle(int aid) {
        return ctrsDao.getCtrsByArticle(aid);
    }

    @Override
    public int getCountByArticle(int aid) {
        return ctrsDao.getCountByArticle(aid);
    }

    @Override
    public int getCountByUser(int uid) {
        // 先查出用户的所有文章的id，再求出每篇文章的点击量，最后想加
        int countAll = 0;

        List<Barticle> barticles = articleDao.queryAllByUser(uid);
        if (barticles!=null){
            for (Barticle art:barticles){
                countAll = countAll + getCountByArticle(art.getAid());
            }
        }

        return countAll;
    }

    @Override
    public int getCountByUserSQL(int uid) {
        int countAll = 0;
        List<Barticle> barticles = articleDao.queryAllByUser(uid);
        if (barticles != null) {
            for (Barticle art : barticles) {
                countAll = countAll + ctrsDao.getCountByArticleSQL(art.getAid());
            }
        }
        return countAll;
    }
}
