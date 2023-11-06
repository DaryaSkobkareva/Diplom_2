package ru.yandex.praktikum.stellarburgers.api.pojo;

import io.qameta.allure.Step;

public class Data {
    private String _id;
    private String name;
    private String type;
    private int proteins;
    private int fat;
    private int carbohydrates;
    private int calories;
    private int price;
    private String image;
    private String image_mobile;
    private String image_large;
    private int __v;
    @Step("id ингредиента")
    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getProteins() {
        return proteins;
    }
    public int getFat() {
        return fat;
    }
    public int getCarbohydrates() {
        return carbohydrates;
    }
    public int getCalories() {
        return calories;
    }
    public int getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
    public String getImage_mobile() {
        return image_mobile;
    }
    public String getImage_large() {
        return image_large;
    }
    public int get__v() {
        return __v;
    }
}
