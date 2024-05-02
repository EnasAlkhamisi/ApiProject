package Week10Assignments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Homework15 {
    public static void main(String[] args) {
        // Base URL for the API
        RestAssured.baseURI = "https://reqres.in/api";

        // Create a user
        Response createResponse = createUser("John", "Doe", "john.doe@example.com");
        int createdUserId = createResponse.jsonPath().getInt("id");

        // Read the created user
        Response readResponse = readUser(createdUserId);

        // Update the created user
        Response updateResponse = updateUser(createdUserId, "John", "Doe", "john.doe.updated@example.com");

        // Delete the created user
        Response deleteResponse = deleteUser(createdUserId);

        // Print the responses
        System.out.println("Create User Response:");
        System.out.println(createResponse.prettyPrint());
        System.out.println("Read User Response:");
        System.out.println(readResponse.prettyPrint());
        System.out.println("Update User Response:");
        System.out.println(updateResponse.prettyPrint());
        System.out.println("Delete User Response:");
        System.out.println(deleteResponse.prettyPrint());
    }

    private static Response createUser(String firstName, String lastName, String email) {
        String requestPayload = "{\n" +
                "    \"first_name\": \"" + firstName + "\",\n" +
                "    \"last_name\": \"" + lastName + "\",\n" +
                "    \"email\": \"" + email + "\"\n" +
                "}";

        return given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post("/users");
    }

    private static Response readUser(int userId) {
        return given()
                .pathParam("id", userId)
                .get("/users/{id}");
    }

    private static Response updateUser(int userId, String firstName, String lastName, String email) {
        String requestPayload = "{\n" +
                "    \"first_name\": \"" + firstName + "\",\n" +
                "    \"last_name\": \"" + lastName + "\",\n" +
                "    \"email\": \"" + email + "\"\n" +
                "}";

        return given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .pathParam("id", userId)
                .put("/users/{id}");
    }

    private static Response deleteUser(int userId) {
        return given()
                .pathParam("id", userId)
                .delete("/users/{id}");
    }
}