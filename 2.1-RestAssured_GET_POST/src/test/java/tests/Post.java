package tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Post {
	
	@Test
	public void get() {
		baseURI="https://reqres.in/api";
		// API POST "https://reqres.in/api/users"
		
		JSONObject json = new JSONObject();
		
		json.put("name", "morpheus");
		json.put("job", "leader");
		
		System.out.println(json.toJSONString());
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(json.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
	}
	
}
