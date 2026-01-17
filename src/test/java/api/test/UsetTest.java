package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UsetTest {

    Faker faker;
    User userPayload;
    Logger logger;

    @BeforeClass
    public void setup() {

        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.number().numberBetween(1, 9999999));
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        logger = LogManager.getLogger(this.getClass());
        logger.info("Test data setup completed");
    }

    @Test(priority = 1)
    public void testPostUser() {

        logger.info("Creating user");

        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void testGetUser() {

        logger.info("Reading user");

        Response response = UserEndpoints.readUser(userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void testUpdateUser() {

        logger.info("Updating user");

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());

        Response response =
                UserEndpoints.updateUser(userPayload.getUsername(), userPayload);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void testDeleteUser() {

        logger.info("Deleting user");

        Response response =
                UserEndpoints.deleteUser(userPayload.getUsername());

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
