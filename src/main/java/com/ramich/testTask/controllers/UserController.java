package com.ramich.testTask.controllers;

import com.ramich.testTask.config.JwtProvider;
import com.ramich.testTask.entities.User;
import com.ramich.testTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;
    private JwtProvider jwtProvider;

    //Инжектим зависимости

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setJwtProvider(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    //Эндпоинты
    //home
    @GetMapping("/")
    public String home(){
        return "home";
    }

    //Регистрируем нового пользователя, получая на вход json с именем и паролем
    @PostMapping("/registration")
    public void register(@RequestBody RegRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userService.saveUser(user);
    }

    //Залогиниваем пользователя, получая на вход json с именем и паролем
    //В ответ отправляем токен пользователя
    @PostMapping("/login")
    public AuthResponce login(@RequestBody RegRequest request){
        User u = userService.findByUsername(request.getUsername());
        String token = jwtProvider.generateToken(u.getUsername());
        return new AuthResponce(token);
    }

    //Получаем список всех зарегестрированных пользователей
    @GetMapping("/getusers")
    public List<User> getUsers(){
        return userService.findAll();
    }
}
