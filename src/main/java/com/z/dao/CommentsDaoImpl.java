package com.z.dao;

import com.z.model.Bcomments;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("commentsDao")
public class CommentsDaoImpl implements CommentsDao {

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
    public void save(Bcomments comms) {
        getSession().save(comms);
    }

    @Override
    public List<Bcomments> getCommentsByArticle(Integer aid) {
        String hql = "from Bcomments bc where bc.article = ? ";
        List<Bcomments> alls = getSession().createQuery(hql).setParameter(0,aid).list();
        return alls;
    }

    @Override
    public void deleteById(Integer id) {
        String hql = "delete Bcomments bc where bc.cid = ? ";
        getSession().createQuery(hql).setParameter(0,id).executeUpdate();

    }
}
