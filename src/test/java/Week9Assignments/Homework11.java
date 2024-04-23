package Week9Assignments;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
public class Homework11 {
    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/

    public static void main(String[] args) {
        // Send GET request
        Response response = RestAssured.get("https://automationexercise.com/api/productsList");

        // Get the JSON response body
        JsonPath jsonPath = response.jsonPath();

        // Get the number of "Women" user types
        int womenUserTypesCount = jsonPath.getList("products.findAll{it.category.usertype.usertype == 'Women'}").size();

        // Assert that the count is 12
        assert womenUserTypesCount == 12;

        // Print the JSON response body
        jsonPath.prettyPrint();
    }
}