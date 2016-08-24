package com.z.dao;

import com.z.model.Buser;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private  SessionFactory sessionFactory = null;
    private  Session session = null;

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
    public Buser getUserById(Integer id) {
        String hql = "from Buser bu where bu.uid = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0,id);
        Buser user = (Buser) query.uniqueResult();
        return user;
    }

    @Override
    public Buser getUserByName(String username) {
        String hql = "from Buser bu where bu.name = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0,username);
        Buser user = (Buser) query.uniqueResult();
        return user;
    }

    @Override
    public void save(Buser user) {
        getSession().save(user);
    }
}
