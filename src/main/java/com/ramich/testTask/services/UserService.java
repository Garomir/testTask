package com.ramich.testTask.services;

import com.ramich.testTask.entities.User;

import java.util.List;

public interface UserService {
    boolean saveUser (User user);
    User findByUsername (String username);
    List<User> findAll();
    void updateUser(User user);
}