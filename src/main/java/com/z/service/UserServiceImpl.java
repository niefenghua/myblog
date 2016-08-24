package com.z.service;

import com.z.dao.UserDao;
import com.z.model.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public Buser getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public Buser getUserByName(String username) {
        return  userDao.getUserByName(username);

    }

    @Override
    public void save(Buser user) {
        userDao.save(user);
    }

    @Override
    public int login(Buser buser) {

        String bname = buser.getName();
        String npass = buser.getPassword();

        Buser user = userDao.getUserByName(bname);
        if (user!=null){
            if(npass.equals(user.getPassword())){
                return 1;
            }
        }



        return 0;
    }

    @Override
    public int register(Buser user) {

        String nname = user.getName();
        Buser nuser = userDao.getUserByName(nname);

        if (nuser==null){
            userDao.save(user);
            return 1;
        }

        return 0;
    }
}
