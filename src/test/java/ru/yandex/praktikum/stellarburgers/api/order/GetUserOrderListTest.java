package ru.yandex.praktikum.stellarburgers.api.order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.praktikum.stellarburgers.api.BaseOrderTest;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;

import static org.hamcrest.CoreMatchers.equalTo;
import static ru.yandex.praktikum.stellarburgers.api.generators.OrderGenerator.*;

public class GetUserOrderListTest extends BaseOrderTest {
    @Test
    @DisplayName("Получение списка заказов пользователя авторизованным пользователем")
    public void checkGetOrderListByAuthorizedUser() {
        Order order = randomOrder(ingredientsHashId);
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
