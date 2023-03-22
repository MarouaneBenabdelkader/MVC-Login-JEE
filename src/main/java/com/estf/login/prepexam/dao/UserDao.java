package com.estf.login.prepexam.dao;

import com.estf.login.prepexam.models.User;

import java.util.List;

public interface UserDao {
    User save(User user);
    User findById(String email);
    List<User> getAll();
    User update(User user);
    User delete(User user);
}
