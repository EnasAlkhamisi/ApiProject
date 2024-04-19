package Week8Assignments;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

public class Homework8 {

    @Test
    void assertionMethod() {
        // Request body
        String requestBody = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

        // Send a POST request
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://reqres.in/api/users");

        // Verify status code is 201
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201);

        // Verify response body
        response.then()
                .body("name", equalTo("morpheus"))
                .body("job", equalTo("leader"))
                .body("id", notNullValue())
                .body("createdAt", notNullValue());
    }
}