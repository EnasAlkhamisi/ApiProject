package Week8Assignments;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework5  {


    /*
         Given
             https://reqres.in/api/users/23
         When
             User send a GET Request to the url
         Then
             HTTP Status code should be 404
         And
             Status Line should be HTTP/1.1 404 Not Found
         And
             Server is "cloudflare"
         And
             Response body should be empty
      */
    @Test
    void assertionMethod() {
//    https://reqres.in/api/users/23
//    User send a GET Request to the url
        Response response = RestAssured.get("https://reqres.in/api/users/23");
        response.prettyPrint();

//    HTTP Status code should be 404
//    Status Line should be HTTP/1.1 404 Not Found
//    Server is "cloudflare"
//    Response body should be empty

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server" , "cloudflare")
                .body(equalTo("{}"));
    }

    }

