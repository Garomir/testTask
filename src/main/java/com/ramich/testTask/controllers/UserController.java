package com.ramich.testTask.controllers;

import com.ramich.testTask.entities.User;
import com.ramich.testTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/registration")
    public void register(@RequestBody @Valid RegDTO dto){
        //System.out.println("" + user.getUsername() + " - " + user.getPassword());
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        userService.saveUser(user);
    }

    @GetMapping("/getusers")
    public List<User> getUsers(){
        /*User user = new User();
        user.setUsername("Ramil");
        user.setPassword("Ramil");
        userService.saveUser(user);*/
        return userService.findAll();
    }
}
