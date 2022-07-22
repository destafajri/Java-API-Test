package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AssuredCartTest {

	RequestSpecification req;
	ValidatableResponse vRes;

	@Test
	public void postGetCart() {
		RestAssured.baseURI = "https://www.gramedia.com/api/user/cart/?version_type=V2&";

		// Request
		req = RestAssured.given();
		req.header("Authorization",
				"JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxNzQyMjg2LCJlbWFpbCI6ImRlc3RhZmFqcmlAZ21haWwuY29tIiwidXNlcm5hbWUiOiJkZXN0YWZhanJpQGdtYWlsLmNvbSIsImV4cCI6MTY1OTcxOTc4MCwib3JpZ19pYXQiOjE2NTg1MTAxODAsImlzcyI6IkdSQU1FRElBIiwiZmlyc3RfbmFtZSI6ImRlc3RhIiwibGFzdF9uYW1lIjoiIn0.iXu7yFeYKNPJ9KJjA_swud09JMpvls4OEgLr527zeRA");

		// panggilan web service menggunakan method GET
		Response response = req.get();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200); //response of success

	}

}
