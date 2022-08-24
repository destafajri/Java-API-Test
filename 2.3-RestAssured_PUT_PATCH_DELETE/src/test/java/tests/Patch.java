package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Patch {

	@Test
	public void patch() {
		baseURI = "https://reqres.in";
		// API POST "https://reqres.in/api/users/2"

		JSONObject json = new JSONObject();

		json.put("name", "morpheus");
		json.put("job", "leader");

		System.out.println(json.toJSONString());

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(json.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();

	}

}
