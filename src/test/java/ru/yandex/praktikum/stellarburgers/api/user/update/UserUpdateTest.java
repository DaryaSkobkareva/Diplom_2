package ru.yandex.praktikum.stellarburgers.api.user.update;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseTest;
import ru.yandex.praktikum.stellarburgers.api.pojo.UpdatedUserData;

import static org.hamcrest.CoreMatchers.equalTo;
import static ru.yandex.praktikum.stellarburgers.api.generators.UpdatedUserDataGenerator.*;

public class UserUpdateTest extends BaseTest {
    private UpdatedUserData updatedUserData;

    @Test
    @DisplayName("Обновление пользовательских данных авторизованным пользователем")
    public void checkUpdateUserDataByAuthorizedUser() {
        updatedUserData = randomNewUserData();
        userSteps.updateUser(accessToken, updatedUserData)
                .assertThat()
                .statusCode(200)
                .and()
                .body("user.email", equalTo(updatedUserData.getUpdatedEmail()))
                .body("user.name", equalTo(updatedUserData.getUpdatedName()));
    }
    @Test
    @DisplayName("Обновление email авторизованным пользователем")
    public void checkUpdateEmailByAuthorizedUser() {
        updatedUserData = randomNewEmail();
        userSteps.updateUser(accessToken, updatedUserData)
                .assertThat()
                .statusCode(200)
                .and()
                .body("user.email", equalTo(updatedUserData.getUpdatedEmail()));
    }
    @Test
    @DisplayName("Обновление имени авторизованным пользователем")
    public void checkUpdateNameByAuthorizedUser() {
        updatedUserData = randomNewName();
        userSteps.updateUser(accessToken, updatedUserData)
                .assertThat()
                .statusCode(200)
                .and()
                .body("user.name", equalTo(updatedUserData.getUpdatedName()));
    }
}
