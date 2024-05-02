package Week10Assignments;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class Homework14 {

    public static void main(String[] args) {
        // Send GET request
        Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");

        // Get the status code
        int statusCode = response.getStatusCode();

        // Assert that the status code is 200
        assert statusCode == 200;

        // Get the JSON response body
        JsonPath jsonPath = response.jsonPath();

        // Get the number of employees
        int numberOfEmployees = jsonPath.getList("data.id").size();

        // Assert that there are 24 employees
        assert numberOfEmployees == 24;

        // Check if "Tiger Nixon" and "Garrett Winters" are among the employees
        boolean isTigerNixonPresent = jsonPath.getList("data.employee_name").contains("Tiger Nixon");
        boolean isGarrettWintersPresent = jsonPath.getList("data.employee_name").contains("Garrett Winters");
        assert isTigerNixonPresent && isGarrettWintersPresent;

        // Get the greatest age
        int greatestAge = jsonPath.getList("data.employee_age").stream()
                .mapToInt(age -> Integer.parseInt(age.toString()))
                .max()
                .orElse(0);

        // Assert that the greatest age is 66
        assert greatestAge == 66;

        // Get the name of the lowest age
        String lowestAgeName = jsonPath.getList("data.employee_age").stream()
                .min((age1, age2) -> Integer.compare(Integer.parseInt(age1.toString()), Integer.parseInt(age2.toString())))
                .map(age -> jsonPath.getString("data.find { it.employee_age == '" + age + "' }.employee_name"))
                .orElse(null);

        // Assert that the name of the lowest age is "Tatyana Fitzpatrick"
        assert lowestAgeName.equals("Tatyana Fitzpatrick");

        // Get the total salary of all employees
        int totalSalary = jsonPath.getList("data.employee_salary").stream()
                .mapToInt(salary -> Integer.parseInt(salary.toString()))
                .sum();

        // Assert that the total salary of all employees is 6,644,770
        assert totalSalary == 6644770;

        // Print the JSON response body
        jsonPath.prettyPrint();
    }
}