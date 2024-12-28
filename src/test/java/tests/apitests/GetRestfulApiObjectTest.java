package tests.apitests;

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.api.BaseApiTestClass;
import org.api.clients.GetRestfulObjectsApiClient;
import org.api.utils.SchemaValidator;
import org.testng.annotations.Test;

public class GetRestfulApiObjectTest extends BaseApiTestClass {

    @Test
    @Description("Check get restful api object")
    public void checkGetRestfulApiObject() {

        Response response = GetRestfulObjectsApiClient.getRestfulObjectsApiResponse(200);

        SchemaValidator.validateJsonSchema(response, "schemas/get-restapi-dev-all-objects.json");

    }


}
