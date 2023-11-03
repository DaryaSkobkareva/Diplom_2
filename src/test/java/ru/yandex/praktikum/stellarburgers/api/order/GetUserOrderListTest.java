package ru.yandex.praktikum.stellarburgers.api.order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseTest;
import ru.yandex.praktikum.stellarburgers.api.generators.OrderGenerator;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;
import ru.yandex.praktikum.stellarburgers.api.steps.OrderSteps;

import static org.hamcrest.CoreMatchers.equalTo;

public class GetUserOrderListTest extends BaseTest {
    private final OrderSteps orderSteps = new OrderSteps();
    @Test
    @DisplayName("Получение списка заказов пользователя авторизованным пользователем")
    public void checkGetOrderListByAuthorizedUser() {
        Order order = OrderGenerator.randomOrder();
        int orderNumber = orderSteps.createOrder(accessToken, order)
                .assertThat()
                .statusCode(200)
                .extract()
                .path("order.number");

        orderSteps.getUserOrdersList(accessToken)
                .assertThat()
                .statusCode(200)
                .and()
                .body("orders[0].number", equalTo(orderNumber));
    }
}
