package Week9Assignments;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework10   {
    //Using the https://petstore.swagger.io/ document,
// write an automation test that finds the number of "pets"
// with the status "available"
// and asserts that there are more than 100.
    @Test
    public void postRequestTest() {

        // Set the base URL for the API
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // Send a GET request to the "findByStatus" endpoint with status parameter as "available"
        Response response = RestAssured.given()
                .queryParam("status", "available")
                .get("/pet/findByStatus");

        // Extract the count of available pets from the response
        int availablePetsCount = response.jsonPath().getList("id").size();

        System.out.println("availablePets = " + availablePetsCount);

        // Assert that the count is more than 100
        Assert.assertTrue(availablePetsCount > 100, "Number of available pets is less than or equal to 100");


    }



}
