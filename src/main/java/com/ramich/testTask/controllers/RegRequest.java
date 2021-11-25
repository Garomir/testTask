package com.ramich.testTask.controllers;

//сущность для отправки пользователю токена
public class RegRequest {
    private String username;
    private String password;

    public RegRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
