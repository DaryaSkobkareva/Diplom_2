package ru.yandex.praktikum.stellarburgers.api.user.login;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseTest;
import ru.yandex.praktikum.stellarburgers.api.steps.ValidateNegativeUserSteps;

import static ru.yandex.praktikum.stellarburgers.api.pojo.UserCreds.*;

public class NegativeUserLogInTest extends BaseTest {
    private ValidatableResponse response;
    private final ValidateNegativeUserSteps check = new ValidateNegativeUserSteps();
    @Test
    @DisplayName("Авторизация несуществующего пользователя")
    public void checkUserLogInWithInvalidCreds() {
        response = userSteps.logInUser(takeInvalidCreds());
        check.responseForUserLogInWithInvalidCreds(response);
    }
    @Test
    @DisplayName("Авторизация пользователя с некорректным логином")
    public void checkUserLogInWithInvalidLogin() {
        response = userSteps.logInUser(takeCredsWithInvalidLoginFrom(user));
        check.responseForUserLogInWithInvalidCreds(response);
    }
    @Test
    @DisplayName("Авторизация пользователя с некорректным паролем")
    public void checkUserLogInWithInvalidPassword() {
        response = userSteps.logInUser(takeCredsWithInvalidPasswordFrom(user));
        check.responseForUserLogInWithInvalidCreds(response);
    }
    @Test
    @DisplayName("Авторизация пользователя без ввода логина")
    public void checkUserLogInWithoutInputLogin() {
        response = userSteps.logInUser(takePasswordFrom(user));
        check.responseForUserLogInWithInvalidCreds(response);
    }
    @Test
    @DisplayName("Авторизация пользователя без ввода пароля")
    public void checkUserLogInWithoutInputPassword() {
        response = userSteps.logInUser(takeLoginFrom(user));
        check.responseForUserLogInWithInvalidCreds(response);
    }
}
