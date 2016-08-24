package com.z.dao;

import com.z.model.Preference;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("preferenceDao")
public class PreferenceDaoImpl implements PreferenceDao {
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
    public void save(Preference pref) {
        getSession().save(pref);
    }

    @Override
    public Preference getPreferenceById(Integer id) {
        String hql = "from Preference pr where pr.pid = ?";
        Preference preference = (Preference) getSession().createQuery(hql).setParameter(0,id).uniqueResult();

        return preference;
    }

    @Override
    public Preference getPreferenceByUser(int uid) {
        String hql = "from Preference pr where pr.user = ?";
        Preference preference = (Preference) getSession().createQuery(hql).setParameter(0,uid).uniqueResult();

        return preference;
    }

    @Override
    public void updatePreference(Preference pref) {
        getSession().update(pref);

    }
}
