package Week10Assignments.Homework13;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteUser {
    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static Response deleteUser(String username) {
        return RestAssured.given()
                .baseUri(BASE_URI)
                .delete("/user/" + username);
    }
}