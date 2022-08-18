package tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleAPITest {
	
	@Test
	public void test() {
		Response response= RestAssured.get("https://reqres.in/api/users?page=2");
		
		//Get Method
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime()+"ms");
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
	}
}
