package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Get {
	
	@Test
	public void get() {
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200);
		given().get("/users?page=2").then().body("data[1].id", equalTo(8));
		
		//specific body data
		given().get("/users?page=2").then().body("data.first_name", hasItems("George", "Rachel"));
		
	}
	
}
