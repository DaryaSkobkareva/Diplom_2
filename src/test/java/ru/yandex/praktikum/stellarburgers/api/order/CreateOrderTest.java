package ru.yandex.praktikum.stellarburgers.api.order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseOrderTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static ru.yandex.praktikum.stellarburgers.api.generators.OrderGenerator.*;

public class CreateOrderTest extends BaseOrderTest {
    @Test
    @DisplayName("Создание заказа авторизованным пользователем")
    public void checkCreateOrderByAuthorizedUser() {
        order = randomOrder(ingredientsHashId);
        orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(200)
                .and()
                .body("order.number", notNullValue());
    }
    @Test
    @DisplayName("Создание заказа без ингредиентов авторизованным пользователем")
    public void checkCreateOrderWithoutIngredientsByAuthorizedUser() {
        order = randomOrderWithoutIngredients();
        orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Ingredient ids must be provided"));
    }
    @Test
    @DisplayName("Создание заказа с некорректным хэшем ингредиентов авторизованным пользователем")
    public void checkCreateOrderWithInvalidIngredientsHashByAuthorizedUser() {
        order = randomOrderWithInvalidIngredientsHash();
        orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(500);
    }
}
