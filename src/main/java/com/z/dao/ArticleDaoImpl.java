package com.z.dao;

import com.z.common.Page;
import com.z.model.Barticle;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("articleDao")
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private SessionFactory sessionFactory = null;
    private Session session = null;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Session getSession(){

        try {
            session = sessionFactory.getCurrentSession();
        }catch (HibernateException he){
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public void save(Barticle article) {

        getSession().save(article);

    }

    @Override
    public Barticle queryById(Integer id) {
        String hql = "from Barticle ba where ba.aid = ?";
        Barticle art = (Barticle) getSession().createQuery(hql).setParameter(0,id).uniqueResult();
        return art;
    }

    @Override
    public List<Barticle> queryAll() {
        String hql = "from Barticle ba";
        Query query = getSession().createQuery(hql);
        List<Barticle> barticles = query.list();
        return barticles;
    }

    @Override
    public List<Barticle> queryAllByPage(Page page) {
        String hql = "from Barticle ba";
        Query query = getSession().createQuery(hql);
        query.setMaxResults(page.getPageSize());
        query.setFirstResult(page.getBeginIndex());

        List<Barticle> barticles = query.list();
        return barticles;
    }

    @Override
    public List<Barticle> queryAllByUser(Integer uid) {
        String hql = "from Barticle ba where ba.user=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0,uid);
        List<Barticle> barticles = query.list();
        return barticles;
    }

    @Override
    public List<Barticle> queryAllByUserPage(Integer uid, Page page) {
        String hql = "from Barticle ba where ba.user=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0,uid);
        query.setMaxResults(page.getPageSize());
        query.setFirstResult(page.getBeginIndex());

        List<Barticle> barticles = query.list();
        return barticles;

    }
}
