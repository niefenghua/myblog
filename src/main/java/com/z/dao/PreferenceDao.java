package com.z.dao;

import com.z.model.Preference;


public interface PreferenceDao {

    void save(Preference pref);
    Preference getPreferenceById(Integer id);
    Preference getPreferenceByUser(int uid);
    void updatePreference(Preference pref);
}
