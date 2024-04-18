package Week8Assignments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

/*
      Given
          https://reqres.in/api/users/2
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "email" is "janet.weaver@reqres.in",
      And
          "first_name" is "Janet"
      And
          "last_name" is "Weaver"
      And
          "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
   */
public class Homework4 {
    @Test
    public void test() {

//        https://reqres.in/api/users/2
//        User send GET Request to the URL
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        response.prettyPrint();
        // Assertions
        response
                .then()
//                       HTTP Status Code should be 200
                .statusCode(200)
//                       Response format should be "application/json"
                .contentType(ContentType.JSON)
//                       "email" is "janet.weaver@reqres.in",
                .body("data.email", equalTo("janet.weaver@reqres.in"),
//                        "first_name" is "Janet"
                        "data.first_name", equalTo("Janet"),
//                        "last_name" is "Weaver"
                        "data.last_name", equalTo("Weaver"),
//                        "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}