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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PostRestfulApiObjectTest extends BaseApiTestClass {

    @DataProvider(name = "postRestfulObjects")
    public Object[][] postRestfulObjectsProvider() {
        return new Object[][] {
                {"requests/post-restapi-dev-all-objects.json", "Apple MacBook Pro 16"},
                {"requests/post-restapi-dev-all-objects_2.json", "Apple MacBook Pro 15"},
                {"requests/post-restapi-dev-all-objects_3.json", "Apple MacBook Pro 14"}
        };
    }

    @Test(dataProvider = "postRestfulObjects")
    @Description("Check get restful api object")
    public void checkGetRestfulApiObject(String pathToBody, String expectedName) {

        PostAllObjectsRequest postAllObjectsRequest =
                JsonReader.getDataFromJson(PostAllObjectsRequest.class, pathToBody);

        Response response = PostRestfulObjectsApiClient.postRestfulObjectsApiResponse(postAllObjectsRequest, 200);

        SchemaValidator.validateJsonSchema(response, "schemas/post-restapi-dev-all-objects.json");

        PostAllObjectsResponse postAllObjectsResponse = response.as(PostAllObjectsResponse.class);
        JakartaValidator.isValid(postAllObjectsResponse);

        Assert.assertEquals(postAllObjectsResponse.getName(), expectedName,
                "Response name is not valid");
    }

}
