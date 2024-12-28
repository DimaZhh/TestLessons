package tests.apitests;

import static org.api.utils.JsonMapper.getJsonMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.response.Response;
import java.util.List;
import jdk.jfr.Description;
import org.api.BaseApiTestClass;
import org.api.clients.GetRestfulObjectsApiClient;
import org.api.models.GetAllObjects;
import org.api.utils.SchemaValidator;
import org.testng.annotations.Test;

public class GetRestfulApiObjectTest extends BaseApiTestClass {

    @Test
    @Description("Check get restful api object")
    public void checkGetRestfulApiObject() throws JsonProcessingException {

        Response response = GetRestfulObjectsApiClient.getRestfulObjectsApiResponse(200);
        SchemaValidator.validateJsonSchema(response, "schemas/get-restapi-dev-all-objects.json");

        List<GetAllObjects> getAllObjects = getJsonMapper().readValue(
                response.getBody().asString(),
                new TypeReference<>() {
                }
        );
        SchemaValidator.validateJsonSchema(getAllObjects, "schemas/get-restapi-dev-all-objects.json");

    }


}
