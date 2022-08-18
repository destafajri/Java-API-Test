package learnTestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AssuredCommentTest {

	RequestSpecification req;
	ValidatableResponse vRes;

	@Test
	public void postGetAll() {
		RestAssured.baseURI = "http://localhost:3000/comments";

		// Request
		req = RestAssured.given();

		// panggilan web service menggunakan method GET
		Response response = req.get();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200);

	}

	@Test
	public void postGetSingleComment() {
		RestAssured.baseURI = "http://localhost:3000/comments/1";

		// Request
		req = RestAssured.given();

		// panggilan web service menggunakan method GET
		Response response = req.get();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200);

	}

	@Test
	public void postComment() {
		String data = "{\r\n" + "    \"title\": \"ayamnya jagoo jago\",\r\n" + "    \"author\": \"mahal\"\r\n" + "}";

		RestAssured.baseURI = "http://localhost:3000/comments";

		// Request
		req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(data);

		// Created data
		Response response = req.post();
		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(201);
	}

	@Test(dependsOnMethods = { "postComment" })
	public void postPutEditComment() {
		String data = "{\r\n" + "    \"title\": \"ayam jago\",\r\n" + "    \"author\": \"mahal\"\r\n" + "}";

		RestAssured.baseURI = "http://localhost:3000/comments/3";

		// Request
		req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(data);

		// Created data
		Response response = req.put();
//		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200);
	}

	@Test(dependsOnMethods = { "postPutEditComment" })
	public void postDelete() {

		RestAssured.baseURI = "http://localhost:3000/comments/3";

		// Request
		req = RestAssured.given();

		// Created data
		Response response = req.delete();
//		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200);
	}

}
