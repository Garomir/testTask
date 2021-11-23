package com.ramich.testTask.controllers;

public class AuthResponce {
    private String token;

    public AuthResponce(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
