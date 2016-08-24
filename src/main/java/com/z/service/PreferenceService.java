package com.z.service;

import com.z.model.Preference;

public interface PreferenceService {
    void save(Preference pref);
    Preference getPreferenceById(Integer id);
    Preference getPreferenceByUser(int uid);
    void updatePreference(String username,Preference pref);

}
