package in.co.gorest.gorestinfo;

import in.co.gorest.constants.EndPoints;
import in.co.gorest.model.GoRestPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class GoRestSteps {

    @Step("Creating user with usersId :{0} name : {1}, email:{2},gender:{3},status:{4}")
    public ValidatableResponse createUser(String name, String email,String gender,String status){
        GoRestPojo goRestPojo = new GoRestPojo();
        goRestPojo.setName(name);
        goRestPojo.setEmail(email);
        goRestPojo.setGender(gender);
        goRestPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 75c987adac5bd1820e58fb137137e2474501428068d1ec0dd68ae05bcff564c9")
                .body(goRestPojo)
                .when()
                .post(EndPoints.CREATE_SINGLE_USERS)
                .then();
    }
    @Step("Getting the User information with Id: {0}")
    public HashMap<String, ?> getUserInfoByName(String usersId) {

        HashMap<String, ?> userMap = SerenityRest.given().log().all()
                .when()
                .pathParam("usersId", usersId)
                .get(EndPoints.GET_SINGLE_USERS_BY_ID)
                .then()
                .statusCode(200)
                .extract().path("");

        return userMap;
    }
    @Step("Update User usersId :{0} name : {1}, email:{2},gender:{3},status:{4}")
    public ValidatableResponse updateUserByPatch(String usersId,String name, String email,String gender,String status) {
        GoRestPojo goRestPojo = new GoRestPojo();
        goRestPojo.setName(name);
        goRestPojo.setEmail(email);
        goRestPojo.setGender(gender);
        goRestPojo.setStatus(status);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("usersId", usersId)
                .body(goRestPojo)
                .when()
                .patch(EndPoints.UPDATE_USERS_BY_ID)
                .then();
    }
}



