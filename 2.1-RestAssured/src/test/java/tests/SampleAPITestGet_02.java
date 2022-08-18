package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class SampleAPITestGet_02 {
	
	@Test
	public void testSample_01() {
		Response response= get("https://reqres.in/api/users?page=2");
		
		//Get Method
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime()+"ms");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		//Assert
		int statusCode=response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testSample_02() {
		baseURI="https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200);
		given().get("/users?page=2").then().body("data[1].id", equalTo(8));
		
	}
	
	
}
