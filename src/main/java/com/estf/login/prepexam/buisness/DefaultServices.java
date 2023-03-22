package com.estf.login.prepexam.buisness;

import com.estf.login.prepexam.dao.UserDao;
import com.estf.login.prepexam.dao.UserDaoMemory;
import com.estf.login.prepexam.models.User;

import java.util.List;

public class DefaultServices implements Service{
    private UserDao userDao;
    private static DefaultServices instance = null;
    private DefaultServices() {
        userDao = new UserDaoMemory();
    }

    public static DefaultServices getInstance(){

        if(instance == null)
            instance = new DefaultServices();
        return instance;
    }


    @Override
    public User addUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User getUseById(String email) {
        return userDao.findById(email);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAll();
    }

    @Override
    public User modifyUser(User user) {
        return userDao.update(user);
    }

    @Override
    public User removeUser(User user) {
        return userDao.delete(user);
    }
}
