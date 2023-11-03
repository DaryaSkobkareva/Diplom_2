package ru.yandex.praktikum.stellarburgers.api.generators;

import io.qameta.allure.Step;
import ru.yandex.praktikum.stellarburgers.api.pojo.User;
import ru.yandex.praktikum.stellarburgers.api.utils.Utils;

public class UserGenerator extends Utils {
    @Step("Генерация пользователя")
    public static User randomUser() {
        return new User()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password())
                .withName(faker.name().username());
    }
    @Step("Генерация пользователя без email")
    public static User randomUserWithoutEmail() {
        return new User()
                .withPassword(faker.internet().password())
                .withName(faker.name().username());
    }
    @Step("Генерация пользователя без password")
    public static User randomUserWithoutPassword() {
        return new User()
                .withEmail(faker.internet().emailAddress())
                .withName(faker.name().username());
    }
    @Step("Генерация пользователя без name")
    public static User randomUserWithoutName() {
        return new User()
                .withEmail(faker.internet().emailAddress())
                .withPassword(faker.internet().password());
    }
}
