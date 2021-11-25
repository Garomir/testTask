package com.ramich.testTask.controllers;

//сущность для получения сообщения от пользователя
public class MessageRequest {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
