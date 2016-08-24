package com.z.dao;

import com.z.model.Buser;

public interface UserDao {

    void save(Buser user);

    Buser getUserById(Integer id);

    Buser getUserByName(String username);

}
