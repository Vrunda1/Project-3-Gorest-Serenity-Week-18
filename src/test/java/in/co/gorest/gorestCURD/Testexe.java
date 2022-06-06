package in.co.gorest.gorestCURD;

import in.co.gorest.constants.EndPoints;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Testexe extends TestBase {
   @Test
   public void getEmployeeList() {
       SerenityRest.given()
               .when()
               .get(EndPoints.GET_ALL_USERS)
               .then().log().all();


   }

}
