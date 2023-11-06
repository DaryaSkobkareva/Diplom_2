package ru.yandex.praktikum.stellarburgers.api.steps;

import io.qameta.allure.Step;
import ru.yandex.praktikum.stellarburgers.api.configuration.BaseRq;
import ru.yandex.praktikum.stellarburgers.api.pojo.Data;
import ru.yandex.praktikum.stellarburgers.api.pojo.Ingredients;

import java.util.ArrayList;
import java.util.List;

import static ru.yandex.praktikum.stellarburgers.api.configuration.Endpoints.*;

public class IngredientSteps extends BaseRq {
    @Step("Получение списка ингредиентов")
    public List<String> getIngredientsHashList() {
        Ingredients ingredients = spec()
                .get(GET_INGREDIENTS_LIST)
                .body()
                .as(Ingredients.class);

        List<Data> data = ingredients.getData();

        List<String> ingredientsHashList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            ingredientsHashList.add(i, data.get(i).get_id());
        }
        return ingredientsHashList;
    }
}
