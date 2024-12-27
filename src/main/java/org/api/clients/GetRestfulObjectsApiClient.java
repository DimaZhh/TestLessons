package org.api.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import org.api.BaseApiTestClass;

public class GetRestfulObjectsApiClient {

    public static Response getRestfulObjectsApiResponse(String baseUrl, int statusCode) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        Map<String, String> queryParams = new HashMap<>();

        RequestSpecification specification = BaseApiTestClass
                .getBaseSpecification(baseUrl);

        return BaseApiTestClass.sendGetRequest(specification, headers, "objects", statusCode);
    }

    public static Object getRestfulObjectsApiResponseByType(String baseUrl, int statusCode) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        Map<String, String> queryParams = new HashMap<>();

        RequestSpecification specification = BaseApiTestClass
                .getBaseSpecification(baseUrl);

        return BaseApiTestClass.sendGetRequest(specification, headers, "objects", statusCode, Object.class);
    }

}
