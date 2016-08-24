package com.z.service;

import com.z.dao.PreferenceDao;
import com.z.dao.UserDao;
import com.z.model.Buser;
import com.z.model.Preference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("preferenceService")
public class PreferenceServiceImpl implements PreferenceService{

    @Autowired
    private PreferenceDao preferenceDao;
    @Autowired
    private UserDao userDao;

    public PreferenceDao getPreferenceDao() {
        return preferenceDao;
    }

    public void setPreferenceDao(PreferenceDao preferenceDao) {
        this.preferenceDao = preferenceDao;
    }

    @Override
    public void save(Preference pref) {
        preferenceDao.save(pref);

    }

    @Override
    public Preference getPreferenceById(Integer id) {
        Preference pref = preferenceDao.getPreferenceById(id);
        return pref;
    }

    @Override
    public Preference getPreferenceByUser(int uid) {
        Preference pref = preferenceDao.getPreferenceByUser(uid);
        return pref;
    }

    @Override
    public void updatePreference(String username, Preference pref) {
        Buser user = userDao.getUserByName(username);
        Preference preference = preferenceDao.getPreferenceByUser(user.getUid());
        preference.setTitle(pref.getTitle());
        preference.setSignature(pref.getSignature());

        preferenceDao.updatePreference(preference);

    }
}
