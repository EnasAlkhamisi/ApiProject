package Week8Assignments;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Homework6 {

      /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json; charset=utf-8"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

      @Test
      void assertionMethod() {
          // Send a GET request
          given()
                  .get("https://reqres.in/api/unknown/3")
                  .then()
                  .statusCode(200)
                  .contentType(ContentType.JSON)
                  .body("data.id", equalTo(3),
                          "data.name", equalTo("true red"),
                          "data.year", equalTo(2002),
                          "data.color", equalTo("#BF1932"),
                          "data.pantone_value", equalTo("19-1664"),
                          "support.url", equalTo("https://reqres.in/#support-heading"),
                          "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")
                  );
      }

      }
