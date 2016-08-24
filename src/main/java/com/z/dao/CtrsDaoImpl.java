package com.z.dao;

import com.z.model.Ctrs;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ctrsDao")
public class CtrsDaoImpl implements CtrsDao {

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
    public void save(Ctrs ctrs) {
        getSession().save(ctrs);

    }

    @Override
    public List<Ctrs> getCtrsByArticle(int aid) {
        String hql = "from Ctrs ct where ct.article = ?";
        List<Ctrs> ctrss = getSession().createQuery(hql).setParameter(0,aid).list();
        return ctrss;
    }

    @Override
    public long getCountByArticle(int aid) {
        return  getCtrsByArticle(aid).size();
    }
}
