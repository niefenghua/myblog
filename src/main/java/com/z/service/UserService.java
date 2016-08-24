package com.z.service;

import com.z.model.Buser;
public interface UserService {

    void save(Buser user);

    Buser getUserById(Integer id);

    Buser getUserByName(String username);

    int register(Buser user);

    int login(Buser buser);

}
