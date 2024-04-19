package Week8Assignments;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Homework7 {
    /*
         Given
                https://reqres.in/api/unknown/
         When
              I send GET Request to the URL
         Then

              1)Status code is 200
              2)Print all pantone_values
              3)Print all ids greater than 3 on the console
                Assert that there are 3 ids greater than 3
              4)Print all names whose ids are less than 3 on the console
                Assert that the number of names whose ids are less than 3 is 2
      */
    @Test
    void assertionMethod() {
        // Send a GET request
        given()
                .get("https://reqres.in/api/unknown/")
                .then()
                .statusCode(200)
                .body("data.pantone_value", not(empty()))
                .body("data.id.findAll{ it > 3 }.size()", equalTo(3))
                .body("data.findAll{ it.id < 3 }.name.size()", equalTo(2));
    }
}