package tests.apitests;

import static org.api.utils.JsonMapper.getJsonMapper;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.response.Response;
import java.util.List;
import jdk.jfr.Description;
import org.api.BaseApiTestClass;
import org.api.clients.GetRestfulObjectsApiClient;
import org.api.models.GetAllObjects;
import org.api.utils.JakartaValidator;
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
        getAllObjects.forEach(JakartaValidator::isValid);

        Integer year = getAllObjects
                .stream()
                .filter(element -> element.getData() != null)
                .filter(element -> element.getData().getYear() != null)
                .map(element -> element.getData().getYear())
                .filter(element -> element > 2000)
                .filter(element -> element < 3000)
                .distinct()
                .filter(element -> element.equals(2019))
                .findFirst()
                .orElse(null);

        assertNotNull(year);
        assertEquals(year, Integer.valueOf(2019));

    }

}
