package ru.yandex.praktikum.stellarburgers.api.user.login;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseTest;
import ru.yandex.praktikum.stellarburgers.api.pojo.UserCreds;

import static org.hamcrest.CoreMatchers.notNullValue;

public class UserLogInTest extends BaseTest {
    @Test
    @DisplayName("Авторизация пользователя")
    public void checkUserLogIn() {
        accessToken = userSteps.logInUser(UserCreds.takeCredsFrom(user))
                .assertThat()
                .statusCode(200)
                .and()
                .body("accessToken", notNullValue())
                .extract()
                .path("accessToken");
    }
}