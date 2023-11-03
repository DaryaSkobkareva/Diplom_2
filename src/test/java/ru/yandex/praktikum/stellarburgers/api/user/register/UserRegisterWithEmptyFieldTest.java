package ru.yandex.praktikum.stellarburgers.api.user.register;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.pojo.User;
import ru.yandex.praktikum.stellarburgers.api.steps.UserSteps;
import ru.yandex.praktikum.stellarburgers.api.steps.ValidateNegativeUserSteps;

import static ru.yandex.praktikum.stellarburgers.api.generators.UserGenerator.*;

public class UserRegisterWithEmptyFieldTest {
    private User user;
    private ValidatableResponse response;
    private final UserSteps userSteps = new UserSteps();
    private final ValidateNegativeUserSteps check = new ValidateNegativeUserSteps();
    @Test
    @DisplayName("Регистрация пользователя без логина")
    public void checkUserRegisterWithoutLogin() {
        user = randomUserWithoutEmail();
        response = userSteps.registerUser(user);
        check.responseForUserRegisterWithEmptyField(response);
    }
    @Test
    @DisplayName("Регистрация пользователя без пароля")
    public void checkUserRegisterWithoutPassword() {
        user = randomUserWithoutPassword();
        response = userSteps.registerUser(user);
        check.responseForUserRegisterWithEmptyField(response);
    }
    @Test
    @DisplayName("Регистрация пользователя без имени")
    public void checkUserRegisterWithoutName() {
        user = randomUserWithoutName();
        response = userSteps.registerUser(user);
        check.responseForUserRegisterWithEmptyField(response);
    }
}
