package com.ramich.testTask.services;

import com.ramich.testTask.entities.User;

import java.util.List;

public interface UserService {
    void saveUser (User user);
    User findByUsername (String username);
    List<User> findAll();
}