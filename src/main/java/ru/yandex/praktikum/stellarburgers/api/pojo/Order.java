package ru.yandex.praktikum.stellarburgers.api.pojo;

import io.qameta.allure.Step;

import java.util.List;

public class Order {
    private List<String> ingredients;

    public Order(){
    }
    @Step("Ингредиенты в заказе")
    public Order withIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
