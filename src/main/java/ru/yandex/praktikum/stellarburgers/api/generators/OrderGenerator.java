package ru.yandex.praktikum.stellarburgers.api.generators;

import io.qameta.allure.Step;
import ru.yandex.praktikum.stellarburgers.api.pojo.Order;
import ru.yandex.praktikum.stellarburgers.api.utils.Utils;

import java.util.List;

public class OrderGenerator extends Utils {
    @Step("Генерация заказа")
    public static Order randomOrder(List<String> ingredientsHashList) {
        List<String> ingredients = List.of
                (ingredientsHashList.get(random.nextInt(ingredientsHashList.size())),
                ingredientsHashList.get(random.nextInt(ingredientsHashList.size())),
                ingredientsHashList.get(random.nextInt(ingredientsHashList.size())),
                ingredientsHashList.get(random.nextInt(ingredientsHashList.size())));
        return new Order()
                .withIngredients(ingredients);
    }
    @Step("Генерация заказа без ингредиентов")
    public static Order randomOrderWithoutIngredients() {
        List<String> ingredients = List.of();
        return new Order()
                .withIngredients(ingredients);
    }
    @Step("Генерация заказа с неверным хэшем ингредиентов")
    public static Order randomOrderWithInvalidIngredientsHash() {
        List<String> ingredients = List.of
                (String.valueOf(faker.hashCode()),
                String.valueOf(faker.hashCode()));
        return new Order()
                .withIngredients(ingredients);
    }
}
