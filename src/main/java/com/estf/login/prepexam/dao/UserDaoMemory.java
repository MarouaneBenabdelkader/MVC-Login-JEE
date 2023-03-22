package com.estf.login.prepexam.dao;

import com.estf.login.prepexam.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMemory implements UserDao{
    private static List<User> users;

    public UserDaoMemory() {
        users = new ArrayList<>();
    }

    @Override
    public User save(User user) {
        if(user == null || user.getEmail().equals("") || user.getPassword().equals(""))
            return null;
        for (User user1:users) {
            if(user.getEmail().equals(user1.getEmail()))
                return null;
        }
        users.add(user);
        return user;
    }

    @Override
    public User findById(String email) {
        for (User user:users) {
            if(user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User update(User user) {
        for (User user1:users) {
            if(user1.getEmail().equals(user.getEmail())){
                user1.setPassword(user.getPassword());
                return user1;
            }
        }
        return null;
    }

    @Override
    public User delete(User user) {
        users.remove(user);
        return user;
    }
}
