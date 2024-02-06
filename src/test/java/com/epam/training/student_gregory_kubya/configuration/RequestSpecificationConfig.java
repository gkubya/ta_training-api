package com.epam.training.student_gregory_kubya.configuration;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;

public class RequestSpecificationConfig {

  private static final String BASE_URI = "http://localhost:8080";
  private static final String BASE_PATH = "/api/v3/user/";

  public static RequestSpecification getRequestSpecification() {
    Assertions.setPrintAssertionsDescription(true);
    return RestAssured.given().
        baseUri(BASE_URI).
        basePath(BASE_PATH).
        contentType(ContentType.JSON).
        filters(new AllureRestAssured());
  }
}
