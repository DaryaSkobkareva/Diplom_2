package ru.yandex.praktikum.stellarburgers.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.stellarburgers.api.configuration.BaseRq;
import ru.yandex.praktikum.stellarburgers.api.configuration.Endpoints;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;

public class OrderSteps extends BaseRq {
    @Step("Создание заказа")
    public ValidatableResponse createOrder(String accessToken, Order order) {
        return spec()
                .header("Authorization", accessToken)
                .body(order)
                .when()
                .post(Endpoints.CREATE_ORDER)
                .then();
    }
    @Step("Получение списка заказов пользователя")
    public ValidatableResponse getUserOrdersList(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .get(Endpoints.USER_ORDERS_LIST)
                .then();
    }
}
