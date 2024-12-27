package apitests;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiRequestLogger implements Filter {

    private static final Logger log = LoggerFactory.getLogger(ApiRequestLogger.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec, FilterContext ctx) {

        Response response = ctx.next(requestSpec, responseSpec);
        if (response.statusCode() != 200 && response.statusCode() != 201) {
            log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " + response.getStatusCode() + " " +
                    response.getStatusLine());
        }
        log.info("""
                        {} {}
                        Request Body => {}
                        Request Headers => {}
                        Response Status => {} {}
                        Response Body => {}
                        """, requestSpec.getMethod(), requestSpec.getURI(), requestSpec.getBody(), requestSpec.getHeaders(),
                response.getStatusCode(), response.getStatusLine(), response.getBody().prettyPrint());
        return response;
    }
}
