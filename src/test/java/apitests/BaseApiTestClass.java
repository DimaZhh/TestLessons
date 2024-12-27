package apitests;

import static io.restassured.RestAssured.basic;
import static io.restassured.config.RestAssuredConfig.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.base.BaseTestClass;

public class BaseApiTestClass extends BaseTestClass {

    public static RequestSpecification testApiConfigInit(String baseUrl) {
        return new RequestSpecBuilder().setConfig(config())
                .addFilter(new ErrorLoggingFilter())
                .addFilter(new ApiRequestLogger())
                .setContentType(ContentType.JSON)
                .setAuth(basic("username", "password"))
                .setBaseUri(baseUrl)
                .build();
    }

}
