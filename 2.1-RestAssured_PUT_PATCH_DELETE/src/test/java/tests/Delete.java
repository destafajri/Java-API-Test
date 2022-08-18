package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Delete {

	@Test
	public void delete() {
		baseURI = "https://reqres.in";
		// API POST "https://reqres.in/api/users/2"

		when().delete("/api/users/2").then().statusCode(204).log().all();

	}

}
