package ru.yandex.praktikum.stellarburgers.api.user.register;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.generators.UserGenerator;
import ru.yandex.praktikum.stellarburgers.api.pojo.User;
import ru.yandex.praktikum.stellarburgers.api.steps.UserSteps;

import static org.hamcrest.CoreMatchers.equalTo;

public class UserRegisterTest {
    private final UserSteps userSteps = new UserSteps();
    private String accessToken;
    @Test
    @DisplayName("Регистрация пользователя")
    public void checkUserRegister() {
        User user = UserGenerator.randomUser();
        accessToken = userSteps.registerUser(user)
                .assertThat()
                .statusCode(200)
                .and()
                .body("user.email", equalTo(user.getEmail()))
                .body("user.name", equalTo(user.getName()))
                .extract()
                .path("accessToken");
    }
    @After
    public void tearDown() {
        userSteps.deleteUser(accessToken)
                .assertThat()
                .statusCode(202);
    }
}
