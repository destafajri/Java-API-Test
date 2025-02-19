package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAPITestGet_01 {
	
	@Test
	public void testSample_01() {
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
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
	
	
}
