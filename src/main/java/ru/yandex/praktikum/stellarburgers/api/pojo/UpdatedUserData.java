package ru.yandex.praktikum.stellarburgers.api.pojo;

import io.qameta.allure.Step;

public class UpdatedUserData {
    private String email;
    private String name;

    public UpdatedUserData() {
    }
    @Step("Новый email пользователя")
    public UpdatedUserData withUpdatedEmail(String email) {
        this.email = email;
        return this;
    }
    @Step("Новое имя пользователя")
    public UpdatedUserData withUpdatedName(String name) {
        this.name = name;
        return this;
    }
    @Step("Получить новый email пользователя")
    public String getUpdatedEmail() {
        return email;
    }
    @Step("Получить новое имя пользователя")
    public String getUpdatedName() {
        return name;
    }
}
