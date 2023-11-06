package ru.yandex.praktikum.stellarburgers.api.user;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;
import ru.yandex.praktikum.stellarburgers.api.pojo.UpdatedUserData;
import ru.yandex.praktikum.stellarburgers.api.steps.IngredientSteps;
import ru.yandex.praktikum.stellarburgers.api.steps.OrderSteps;
import ru.yandex.praktikum.stellarburgers.api.steps.UserSteps;
import ru.yandex.praktikum.stellarburgers.api.steps.ValidateNegativeUserSteps;

import java.util.List;

import static ru.yandex.praktikum.stellarburgers.api.generators.OrderGenerator.*;
import static ru.yandex.praktikum.stellarburgers.api.generators.UpdatedUserDataGenerator.*;

public class UnauthorizedUserTest {
    private ValidatableResponse response;
    private final UserSteps userSteps = new UserSteps();
    private final OrderSteps orderSteps = new OrderSteps();
    private final IngredientSteps ingredientSteps = new IngredientSteps();
    private final ValidateNegativeUserSteps check = new ValidateNegativeUserSteps();
    private final String accessToken = "";

    @Test
    @DisplayName("Обновление пользовательских данных неавторизованным пользователем")
    public void checkUpdateUserDataByUnauthorizedUser() {
        UpdatedUserData updatedUserData = randomNewUserData();
        response = userSteps.updateUser(accessToken, updatedUserData);
        check.responseForUnauthorizedUserSteps(response);
    }
    @Test
    @DisplayName("Создание заказа неавторизованным пользователем")
    public void checkCreateOrderByUnauthorizedUser() {
        List<String> ingredientsHashId = ingredientSteps.getIngredientsHashList();
        Order order = randomOrder(ingredientsHashId);
        response = orderSteps.createOrder(accessToken, order);
        check.responseForUnauthorizedUserSteps(response);//Баг - можно создать заказ неавторизованным пользователем
    }
    @Test
    @DisplayName("Получение списка заказов пользователя неавторизованным пользователем")
    public void checkGetOrderListByUnauthorizedUser() {
        response = orderSteps.getUserOrdersList(accessToken);
        check.responseForUnauthorizedUserSteps(response);
    }
}