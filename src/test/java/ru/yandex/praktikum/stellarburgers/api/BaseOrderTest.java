package ru.yandex.praktikum.stellarburgers.api;

import org.junit.Before;
import ru.yandex.praktikum.stellarburgers.api.generators.UserGenerator;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;
import ru.yandex.praktikum.stellarburgers.api.steps.IngredientSteps;
import ru.yandex.praktikum.stellarburgers.api.steps.OrderSteps;

import java.util.List;

public class BaseOrderTest extends BaseTest {
    protected Order order;
    protected List<String> ingredientsHashId;
    protected OrderSteps orderSteps = new OrderSteps();
    protected IngredientSteps ingredientSteps = new IngredientSteps();
    @Override
    @Before
    public void setUp() {
        user = UserGenerator.randomUser();
        accessToken = userSteps.registerUser(user)
                .assertThat()
                .statusCode(200)
                .extract()
                .path("accessToken");
        ingredientsHashId = ingredientSteps.getIngredientsHashList();
    }
}
