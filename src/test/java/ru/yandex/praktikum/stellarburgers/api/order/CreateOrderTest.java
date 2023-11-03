package ru.yandex.praktikum.stellarburgers.api.order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseTest;
import ru.yandex.praktikum.stellarburgers.api.generators.OrderGenerator;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;
import ru.yandex.praktikum.stellarburgers.api.steps.OrderSteps;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateOrderTest extends BaseTest {
    private Order order;
    private final OrderSteps orderSteps = new OrderSteps();
    @Test
    @DisplayName("Создание заказа авторизованным пользователем")
    public void checkCreateOrderByAuthorizedUser() {
        order = OrderGenerator.randomOrder();
        orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(200)
                .and()
                .body("order.number", notNullValue());
    }
    @Test
    @DisplayName("Создание заказа без ингредиентов авторизованным пользователем")
    public void checkCreateOrderWithoutIngredientsByAuthorizedUser() {
        order = OrderGenerator.randomOrderWithoutIngredients();
        orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(400)
                .and()
                .body("message", equalTo("Ingredient ids must be provided"));
    }
    @Test
    @DisplayName("Создание заказа с некорректным хэшем ингредиентов авторизованным пользователем")
    public void checkCreateOrderWithInvalidIngredientsHashByAuthorizedUser() {
        order = OrderGenerator.randomOrderWithInvalidIngredientsHash();
        orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(500);
    }
}
