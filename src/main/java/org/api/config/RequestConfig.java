package org.api.config;

import static io.restassured.RestAssured.basic;
import static io.restassured.config.RestAssuredConfig.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.api.BaseApiTestClass;
import org.api.filter.ApiRequestLogger;

public class RequestConfig {

    public static RequestSpecification testApiConfigInit(String baseUrl) {
        return new RequestSpecBuilder().setConfig(config())
                .addFilter(new ErrorLoggingFilter())
                .addFilter(new ApiRequestLogger())
                .setContentType(ContentType.JSON)
                .setAuth(basic(BaseApiTestClass.getReadPropertyFile().getPropertyByValue("api.username"),
                        BaseApiTestClass.getReadPropertyFile().getPropertyByValue("api.password")))
                .setBaseUri(baseUrl)
                .build();
    }

}
