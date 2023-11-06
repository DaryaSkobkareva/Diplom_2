package ru.yandex.praktikum.stellarburgers.api;

import org.junit.After;
import org.junit.Before;
import ru.yandex.praktikum.stellarburgers.api.generators.UserGenerator;
import ru.yandex.praktikum.stellarburgers.api.pojo.User;
import ru.yandex.praktikum.stellarburgers.api.steps.UserSteps;

public class BaseTest {
    protected User user;
    protected UserSteps userSteps = new UserSteps();
    protected String accessToken;
    @Before
    public void setUp() {
        user = UserGenerator.randomUser();
        accessToken = userSteps.registerUser(user)
                .assertThat()
                .statusCode(200)
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
