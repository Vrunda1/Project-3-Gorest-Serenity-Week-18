package in.co.gorest.gorestCURD;


import in.co.gorest.gorestinfo.GoRestSteps;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;

/**
 * Created by Jay
 */
@RunWith(SerenityRunner.class)
public class UsersCURDTestWithSteps extends TestBase {

    static String name = "John" + TestUtils.getRandomValue();
    static String email = "michael.lawson1@reqres.in";
    static String gender = "female";
    static String status = "active";
    static String token;

    static String userId;

    GoRestSteps goRestSteps;

    @Title("This will create a new user")
    @Test
    public void test001() {
        ValidatableResponse response = goRestSteps.createUser(name, email,gender,status);
        response.log().all().statusCode(201);

    }
    @Title("Verify that new user is added")
    @Test
    public void test002() {
        HashMap<String, Object> userMap = (HashMap<String, Object>) goRestSteps.getUserInfoByName(userId);
        Assert.assertThat(userMap, hasValue(name));
        System.out.println(userMap);
    }

    @Title("This will update a user ")
    @Test
    public void test004() {
        name = name + "_updatedbyPut";
        ValidatableResponse response = goRestSteps.updateUserByPatch(userId, name,  email,gender,status);
        response.log().all().statusCode(200);

    }


    @Title("This will update a user")
    @Test
    public void test005() {
        name = name + "_updatedbyPatch";
        ValidatableResponse response = goRestSteps.updateUserByPatch(userId, name, email,gender,status);
        response.log().all().statusCode(200);
    }




}
