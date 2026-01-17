package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//here we just capturing response not validating
//validating only in test class
public class UserEndpoints {

	public static Response createUser(User payload)

	{
		Response response = given().contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)

				.when()
				.post(routes.post_url);

		return response;

	}

	public static Response readUser(String userName) {

		Response response = given()
				.pathParam("username", userName)//pathparan name, 2. value assigne String username

				.when()
				.get(routes.get_url);
		return response;
	}

	public static Response updateUser(String userName,User payload ) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)

				.when().put(routes.put_url);
		return response;

	}

	public static Response deleteUser(String userName) {

		Response response = given().pathParam("username", userName)

				.when().delete(routes.delete_url);
		return response;
	}

}
