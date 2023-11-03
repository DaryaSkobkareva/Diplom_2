package ru.yandex.praktikum.stellarburgers.api.pojo;

import io.qameta.allure.Step;

public class User {
    private String email;
    private String password;
    private String name;

    public User() {
    }
    @Step("Email пользователя")
    public User withEmail(String email) {
        this.email = email;
        return this;
    }
    @Step("Пароль пользователя")
    public User withPassword(String password) {
        this.password = password;
        return this;
    }
    @Step("Имя пользователя")
    public User withName(String name) {
        this.name = name;
        return this;
    }
    @Step("Получить email пользователя")
    public String getEmail() {
        return email;
    }
    @Step("Получить пароль пользователя")
    public String getPassword() {
        return password;
    }
    @Step("Получить имя пользователя")
    public String getName() {
        return name;
    }
}
