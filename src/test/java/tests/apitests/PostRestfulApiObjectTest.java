package tests.apitests;

import io.restassured.response.Response;
import jdk.jfr.Description;
import org.api.BaseApiTestClass;
import org.api.clients.PostRestfulObjectsApiClient;
import org.api.models.requests.PostAllObjectsRequest;
import org.api.models.responses.PostAllObjectsResponse;
import org.api.utils.JakartaValidator;
import org.api.utils.JsonReader;
import org.api.utils.SchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostRestfulApiObjectTest extends BaseApiTestClass {


    @Test
    @Description("Check get restful api object")
    public void checkGetRestfulApiObject() {

        PostAllObjectsRequest postAllObjectsRequest =
                JsonReader.getDataFromJson(PostAllObjectsRequest.class, "requests/post-restapi-dev-all-objects.json");

        Response response = PostRestfulObjectsApiClient.postRestfulObjectsApiResponse(postAllObjectsRequest, 200);

        SchemaValidator.validateJsonSchema(response, "schemas/post-restapi-dev-all-objects.json");

        PostAllObjectsResponse postAllObjectsResponse = response.as(PostAllObjectsResponse.class);
        JakartaValidator.isValid(postAllObjectsResponse);

        Assert.assertEquals(postAllObjectsResponse.getName(), "Apple MacBook Pro 16",
                "Response name is not valid");
    }

}
