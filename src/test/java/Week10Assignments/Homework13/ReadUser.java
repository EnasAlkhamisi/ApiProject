package Week10Assignments.Homework13;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadUser {
    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static Response readUser(String username) {
        return RestAssured.given()
                .baseUri(BASE_URI)
                .get("/user/" + username);
    }
}