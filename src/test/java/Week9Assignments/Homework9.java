package Week9Assignments;

import base_urls.UserBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*
Write an automation test that will create a 'user' using the "https://petstore.swagger.io/" document
*/

public class Homework9 extends UserBaseUrl {

    @Test
    public void postRequestTest() {

        // Set the Url
        spec.pathParams("first", "v2", "second", "user");

        // Set the expected data(Payload)
        String expectedData = """
                                {
                                  "id": 1,
                                  "username": "john01",
                                  "firstName": "John",
                                  "lastName": "Doe",
                                  "email": "John101@gmail.com",
                                  "password": "123456",
                                  "phone": "654321",
                                  "userStatus": 1
                                }""";

        // Send the request and get the response
        Response response = given(spec)
                .contentType(ContentType.JSON)
                .body(expectedData)
                .post("/{first}/{second}");

        response.prettyPrint();

        // Do assertion
        response
                .then()
                .statusCode(200)
                .body("message", equalTo("1")
                );
    }
}