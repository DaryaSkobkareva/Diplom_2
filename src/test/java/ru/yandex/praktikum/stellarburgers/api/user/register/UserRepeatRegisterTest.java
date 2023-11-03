package ru.yandex.praktikum.stellarburgers.api.user.register;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseTest;
import ru.yandex.praktikum.stellarburgers.api.steps.ValidateNegativeUserSteps;

public class UserRepeatRegisterTest extends BaseTest {
    private final ValidateNegativeUserSteps check = new ValidateNegativeUserSteps();
    @Test
    @DisplayName("Повторная регистрация зарегистрированного пользователя")
    public void checkRepeatUserRegister() {
        ValidatableResponse response = userSteps.registerUser(user);
        check.responseForRepeatUserRegister(response);
    }
}
