package ru.yandex.praktikum.stellarburgers.api.configuration;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static ru.yandex.praktikum.stellarburgers.api.configuration.BaseURI.BASE_URI;

public class BaseRq {
    public RequestSpecification spec() {
        return given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }
}