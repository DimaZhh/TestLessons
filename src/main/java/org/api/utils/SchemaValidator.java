package org.api.utils;

import static io.restassured.RestAssured.given;
import static org.api.utils.JsonMapper.getJsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class SchemaValidator {

    public static void validateJsonSchema(Object responseObject, String schemaPath) throws JsonProcessingException {
        
        String jsonResponse = getJsonMapper().writeValueAsString(responseObject);

        given()
                .body(jsonResponse)
                .when()
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
    }

    public static void validateJsonSchema(Response response, String schemaPath) {

        response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath));
    }

}
