package com.ramich.testTask.services;

import com.ramich.testTask.entities.Role;
import com.ramich.testTask.entities.User;
import com.ramich.testTask.repos.RoleRepo;
import com.ramich.testTask.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Autowired
    public void setRoleRepo(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public boolean saveUser(User user) {
        User some = findByUsername(user.getUsername());
        if(some != null){
            return false;
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepo.getById(1));
        user.setRoles(roles);
        userRepo.save(user);
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public void updateUser(User user) {
        User some = findByUsername(user.getUsername());
        userRepo.save(user);
    }
}