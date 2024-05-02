package Week9Assignments;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.categoryDatepojo;
import pojos.homework12pojo;
import pojos.tagspojo;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Homework12 {
    //Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
//(All actions must be done on same pet)
    //   (Use Pojo)
/*
{

    "id": 7653897,
    "category": {
        "id": 0,
        "name": "Cat"
    },
    "name": "Kitty",
    "photoUrls": [
        "string",
        "best foto",
        "beauty"
    ],
    "tags": [
        {
            "id": 0,
            "name": "Smooth"
        },
        {
            "id": 2,
            "name": "White"
        }
    ],
    "status": "available"
}
 */

    @Test(priority = 1)
    public void Posturlandupdate(){
        String url="https://petstore.swagger.io/v2/pet";
        //  response.prettyPrint();
        categoryDatepojo category=new categoryDatepojo(0,"Cat");
        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("best foto");
        photoUrls.add("beauty");
//        ArrayList<tagspojo> tagsList = new ArrayList<>();
        tagspojo tags =  new tagspojo(0,"Smooth");
//        tagspojo tags1 = new tagspojo(2,"White");
//        tagsList.add(tags);
        homework12pojo homework12pojo=new homework12pojo(7653897,category,"Kitty",photoUrls,tags,"available");
        System.out.println("pojo = " + homework12pojo);
        Response response = given()
                .contentType(ContentType.JSON)
                .body(homework12pojo)
                .post(url);
        response.prettyPrint();

    }
    @Test(priority = 2, dependsOnMethods = "Posturlandupdate")
    public void geturl(){
        String url="https://petstore.swagger.io/v2/pet/7653897";
        Response response=given().get(url);
        response.prettyPrint();
    }
    @Test(priority = 3, dependsOnMethods = "geturl")
    public void updateurl(){
    }
    @Test(priority = 3, dependsOnMethods = "updateurl")
    public void deleturl(){
        String url="https://petstore.swagger.io/v2/pet/7653897";
        Response response = given().delete(url);//First create a data and delete it. Do not delete some else's data.
        response.prettyPrint();
    }
}