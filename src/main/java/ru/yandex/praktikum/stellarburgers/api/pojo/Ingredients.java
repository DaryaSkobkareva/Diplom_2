package ru.yandex.praktikum.stellarburgers.api.pojo;

import io.qameta.allure.Step;

import java.util.List;

public class Ingredients {
    private boolean success;
    private List<Data> data;
    public boolean isSuccess() {
        return success;
    }
    @Step("Список ингредиентов")
    public List<Data> getData() {
        return data;
    }
}
