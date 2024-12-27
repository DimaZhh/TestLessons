package apitests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import org.api.config.RequestConfig;
import org.base.BaseTestClass;

public class BaseApiTestClass extends BaseTestClass {

    public static RequestSpecification getBaseSpecification(String baseUrl) {
        return given(RequestConfig.testApiConfigInit(baseUrl));
    }

    public static Response sendGetRequest(RequestSpecification requestSpecification,
                                          Map<String, String> headers,
                                          String path,
                                          int statusCode) {

        return requestSpecification.headers(headers).when()
                .log().all()
                .get(path)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response();
    }

    public static <T> T sendGetRequest(RequestSpecification requestSpecification,
                                       Map<String, String> headers,
                                       String path,
                                       int statusCode,
                                       Class<T> responseType) {

        return requestSpecification.headers(headers).when()
                .log().all()
                .get(path)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response()
                .as(responseType);
    }

    public static Response sendPostRequest(RequestSpecification requestSpecification,
                                          Map<String, String> headers,
                                          String path,
                                          int statusCode) {

        return requestSpecification.headers(headers).when()
                .log().all()
                .post(path)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response();
    }

    public static <T> T sendPostRequest(RequestSpecification requestSpecification,
                                       Map<String, String> headers,
                                       String path,
                                       int statusCode,
                                       Class<T> responseType) {

        return requestSpecification.headers(headers).when()
                .log().all()
                .post(path)
                .then()
                .assertThat().statusCode(statusCode)
                .extract()
                .response()
                .as(responseType);
    }

}
