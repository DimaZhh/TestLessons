package org.api.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;
import org.api.BaseApiTestClass;
import org.api.models.requests.PostAllObjectsRequest;

public class PostRestfulObjectsApiClient {

    public static Response postRestfulObjectsApiResponse(PostAllObjectsRequest postAllObjects, int statusCode) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        Map<String, String> queryParams = new HashMap<>();

        RequestSpecification specification = BaseApiTestClass
                .getBaseSpecification(BaseApiTestClass.getReadPropertyFile().getPropertyByValue("api.url"));

        return BaseApiTestClass.sendPostRequest(specification, headers, "objects", postAllObjects, statusCode);
    }

    public static PostAllObjectsRequest postRestfulObjectsApiResponseWithSpecificResponseObject(
            PostAllObjectsRequest postAllObjects, int statusCode) {

        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");

        Map<String, String> queryParams = new HashMap<>();

        RequestSpecification specification = BaseApiTestClass
                .getBaseSpecification(BaseApiTestClass.getReadPropertyFile().getPropertyByValue("api.url"));

        return BaseApiTestClass.sendPostRequest(specification, headers, "objects", statusCode, postAllObjects, PostAllObjectsRequest.class);
    }

}
