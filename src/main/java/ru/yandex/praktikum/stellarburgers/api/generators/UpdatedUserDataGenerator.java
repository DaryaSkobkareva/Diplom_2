package ru.yandex.praktikum.stellarburgers.api.generators;

import io.qameta.allure.Step;
import ru.yandex.praktikum.stellarburgers.api.pojo.UpdatedUserData;
import ru.yandex.praktikum.stellarburgers.api.utils.Utils;

public class UpdatedUserDataGenerator extends Utils {
    @Step("Генерация новых email и name")
    public static UpdatedUserData randomNewUserData() {
        return new UpdatedUserData()
                .withUpdatedEmail(faker.internet().emailAddress())
                .withUpdatedName(faker.name().username());
    }
    @Step("Генерация нового email")
    public static UpdatedUserData randomNewEmail() {
        return new UpdatedUserData()
                .withUpdatedEmail(faker.internet().emailAddress());
    }
    @Step("Генерация нового name")
    public static UpdatedUserData randomNewName() {
        return new UpdatedUserData()
                .withUpdatedName(faker.name().username());
    }
}
