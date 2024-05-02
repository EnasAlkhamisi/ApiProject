package Week10Assignments.Homework13;

import io.restassured.response.Response;

public class Test {
public static void main(String[] args) {
        String username = "testuser";
        String password = "password";
        String newName = "Jane";

        // Create a user
        Response createResponse = CreateUser.createUser(username, password);
        System.out.println("Create User Response:");
        createResponse.prettyPrint();

        // Read the created user
        Response readResponse = ReadUser.readUser(username);
        System.out.println("Read User Response:");
        readResponse.prettyPrint();

        // Update the created user
        Response updateResponse = UpdateUser.updateUser(username, newName);
        System.out.println("Update User Response:");
        updateResponse.prettyPrint();

        // Delete the created user
        Response deleteResponse = DeleteUser.deleteUser(username);
        System.out.println("Delete User Response:");
        deleteResponse.prettyPrint();
    }
}