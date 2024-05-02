package Week10Assignments;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Homework16 {
    public static void main(String[] args) {
        // Base URL for the API
        RestAssured.baseURI = "https://reqres.in/api";

        // Add a contact
        Response addResponse = addContact("John", "Doe", "john.doe@example.com");
        int createdContactId = addResponse.jsonPath().getInt("id");

        // Read the created contact
        Response readResponse = readContact(createdContactId);

        // Update the created contact
        Response updateResponse = updateContact(createdContactId, "John", "Doe", "john.doe.updated@example.com");

        // Delete the created contact
        Response deleteResponse = deleteContact(createdContactId);

        // Negative assertion on the deleted contact
        readResponse = readContact(createdContactId);
        boolean isContactDeleted = readResponse.getStatusCode() == 404;

        // Print the responses
        System.out.println("Add Contact Response:");
        System.out.println(addResponse.prettyPrint());
        System.out.println("Read Contact Response:");
        System.out.println(readResponse.prettyPrint());
        System.out.println("Update Contact Response:");
        System.out.println(updateResponse.prettyPrint());
        System.out.println("Delete Contact Response:");
        System.out.println(deleteResponse.prettyPrint());
        System.out.println("Is Contact Deleted: " + isContactDeleted);
    }

    private static Response addContact(String firstName, String lastName, String email) {
        String requestPayload = "{\n" +
                "    \"first_name\": \"" + firstName + "\",\n" +
                "    \"last_name\": \"" + lastName + "\",\n" +
                "    \"email\": \"" + email + "\"\n" +
                "}";

        return given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post("/contact");
    }

    private static Response readContact(int contactId) {
        return given()
                .pathParam("id", contactId)
                .get("/contact/{id}");
    }

    private static Response updateContact(int contactId, String firstName, String lastName, String email) {
        String requestPayload = "{\n" +
                "    \"first_name\": \"" + firstName + "\",\n" +
                "    \"last_name\": \"" + lastName + "\",\n" +
                "    \"email\": \"" + email + "\"\n" +
                "}";

        return given()
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .pathParam("id", contactId)
                .put("/contact/{id}");
    }

    private static Response deleteContact(int contactId) {
        return given()
                .pathParam("id", contactId)
                .delete("/contact/{id}");
    }
}