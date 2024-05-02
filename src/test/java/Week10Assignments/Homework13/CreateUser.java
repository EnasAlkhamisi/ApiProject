package Week10Assignments.Homework13;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateUser {

    private static final String BASE_URI = "https://petstore.swagger.io/v2";

    public static Response createUser(String username, String password) {
        String requestBody = "{\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"" + username + "\",\n" +
                "    \"firstName\": \"John\",\n" +
                "    \"lastName\": \"Doe\",\n" +
                "    \"email\": \"johndoe@example.com\",\n" +
                "    \"password\": \"" + password + "\",\n" +
                "    \"phone\": \"+1 234 567 8910\",\n" +
                "    \"userStatus\": 0\n" +
                "}";

        return RestAssured.given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/user");
    }
}