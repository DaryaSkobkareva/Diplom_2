package ru.yandex.praktikum.stellarburgers.api.pojo;

import io.qameta.allure.Step;
import ru.yandex.praktikum.stellarburgers.api.utils.Utils;

public class UserCreds extends Utils {
    private String email;
    private String password;

    public UserCreds(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Step("Получение корректнных кредов пользователя")
    public static UserCreds takeCredsFrom(User user) {
        return new UserCreds(user.getEmail(), user.getPassword());
    }
    @Step("Получение некорректнных кредов пользователя")
    public static UserCreds takeInvalidCreds() {
        String invalidEmail = faker.internet().emailAddress();
        String invalidPassword = faker.internet().password();
        return new UserCreds(invalidEmail, invalidPassword);
    }
    @Step("Получение логина пользователя")
    public static UserCreds takeLoginFrom(User user) {
        return new UserCreds(user.getEmail(), "");
    }
    @Step("Получение пароля пользователя")
    public static UserCreds takePasswordFrom(User user) {
        return new UserCreds("", user.getPassword());
    }
    @Step("Получение некорректного логина пользователя")
    public static UserCreds takeCredsWithInvalidLoginFrom(User user) {
        String invalidEmail = faker.internet().emailAddress();
        return new UserCreds(invalidEmail, user.getPassword());
    }
    @Step("Получение некорректного пароля пользователя")
    public static UserCreds takeCredsWithInvalidPasswordFrom(User user) {
        String invalidPassword = faker.internet().password();
        return new UserCreds(user.getEmail(), invalidPassword);
    }
}
