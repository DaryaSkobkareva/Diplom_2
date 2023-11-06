package ru.yandex.praktikum.stellarburgers.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.CoreMatchers.equalTo;

public class ValidateNegativeUserSteps {
    @Step("Ответ на запросы неавторизованного пользователя")
    public void responseForUnauthorizedUserSteps(ValidatableResponse response) {
        response.assertThat()
                .statusCode(401)
                .and()
                .body("message", equalTo("You should be authorised"));
    }
    @Step("Ответ при повторной регистрации зарегистрированного пользователя")
    public void responseForRepeatUserRegister(ValidatableResponse response) {
        response.assertThat()
                .statusCode(403)
                .and()
                .body("message", equalTo("User already exists"));
    }
    @Step("Ответ при регистрации пользователя с пустыми полями")
    public void responseForUserRegisterWithEmptyField(ValidatableResponse response) {
        response.assertThat()
                .statusCode(403)
                .and()
                .body("message", equalTo("Email, password and name are required fields"));
    }
    @Step("Ответ при авторизации пользователя с некорректными данными")
    public void responseForUserLogInWithInvalidCreds(ValidatableResponse response) {
        response.assertThat()
                .statusCode(401)
                .and()
                .body("message", equalTo("email or password are incorrect"));
    }
}
