package com.estf.login.prepexam.buisness;

import com.estf.login.prepexam.models.User;

import java.util.List;

public interface Service {
    User addUser(User user);
    User getUseById(String email);
    List<User> getUsers();
    User modifyUser(User user);
    User removeUser(User user);
}
