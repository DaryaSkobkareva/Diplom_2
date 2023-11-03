package ru.yandex.praktikum.stellarburgers.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.praktikum.stellarburgers.api.configuration.BaseRq;
import ru.yandex.praktikum.stellarburgers.api.pojo.UpdatedUserData;
import ru.yandex.praktikum.stellarburgers.api.pojo.User;
import ru.yandex.praktikum.stellarburgers.api.pojo.UserCreds;

import static ru.yandex.praktikum.stellarburgers.api.configuration.Endpoints.*;
import static ru.yandex.praktikum.stellarburgers.api.configuration.Endpoints.DELETE_USER;

public class UserSteps extends BaseRq {
    @Step("Регистрация пользователя")
    public ValidatableResponse registerUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(REGISTER_USER)
                .then();
    }
    @Step("Авторизация пользователя")
    public ValidatableResponse logInUser(UserCreds userCreds) {
        return spec()
                .body(userCreds)
                .when()
                .post(LOGIN_USER)
                .then();
    }
    @Step("Обновление данных пользователя")
    public ValidatableResponse updateUser(String accessToken, UpdatedUserData updatedUserData) {
        return spec()
                .header("Authorization", accessToken)
                .body(updatedUserData)
                .when()
                .patch(UPDATE_USER)
                .then();
    }
    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_USER)
                .then();
    }
}
