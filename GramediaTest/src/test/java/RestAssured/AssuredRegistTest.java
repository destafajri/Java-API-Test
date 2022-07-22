package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AssuredRegistTest {

	RequestSpecification req;
	ValidatableResponse vRes;

	@Test
	public void postGetRegist() {
		RestAssured.baseURI = "https://www.gramedia.com/api/auth/register/";

		// Request
		req = RestAssured.given();
		req.header("Authorization",
				"JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxNzQyMjg2LCJlbWFpbCI6ImRlc3RhZmFqcmlAZ21haWwuY29tIiwidXNlcm5hbWUiOiJkZXN0YWZhanJpQGdtYWlsLmNvbSIsImV4cCI6MTY1OTcxOTc4MCwib3JpZ19pYXQiOjE2NTg1MTAxODAsImlzcyI6IkdSQU1FRElBIiwiZmlyc3RfbmFtZSI6ImRlc3RhIiwibGFzdF9uYW1lIjoiIn0.iXu7yFeYKNPJ9KJjA_swud09JMpvls4OEgLr527zeRA");

		// panggilan web service menggunakan method GET
		Response response = req.get();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(405); // Method GET not allowed

	}

	@Test
	public void postPostRegist() {
		String data = "{\r\n" + "    \"firstName\": \"desta\",\r\n" + "    \"lastName\": \"\",\r\n"
				+ "    \"email\": \"destafajri@gmail.com\",\r\n" + "    \"verified\": true,\r\n"
				+ "    \"accountType\": \"individual\",\r\n" + "    \"phoneNumber\": \"\",\r\n"
				+ "    \"username\": \"destafajri\",\r\n" + "    \"isSocialLogin\": false,\r\n"
				+ "    \"isSubscribed\": true,\r\n" + "    \"gender\": \"\",\r\n" + "    \"birthDate\": \"\",\r\n"
				+ "    \"favouriteCategory\": [],\r\n" + "    \"occupation\": \"\",\r\n" + "    \"hobby\": [],\r\n"
				+ "    \"registrationDate\": \"2022-07-22T17:08:59.190916+00:00\",\r\n"
				+ "    \"corporatePartner\": {\r\n" + "        \"logo\": \"\",\r\n"
				+ "        \"description\": \"\",\r\n" + "        \"nik\": \"\"\r\n" + "    },\r\n"
				+ "    \"myvalue\": {\r\n" + "        \"id\": \"\",\r\n" + "        \"point\": 0\r\n" + "    }\r\n"
				+ "}";
		
		RestAssured.baseURI = "https://www.gramedia.com/api/auth/register/";

		// Request
		req = RestAssured.given();
		req.header("Authorization",
				"JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxNzQyMjg2LCJlbWFpbCI6ImRlc3RhZmFqcmlAZ21haWwuY29tIiwidXNlcm5hbWUiOiJkZXN0YWZhanJpQGdtYWlsLmNvbSIsImV4cCI6MTY1OTcxOTc4MCwib3JpZ19pYXQiOjE2NTg1MTAxODAsImlzcyI6IkdSQU1FRElBIiwiZmlyc3RfbmFtZSI6ImRlc3RhIiwibGFzdF9uYW1lIjoiIn0.iXu7yFeYKNPJ9KJjA_swud09JMpvls4OEgLr527zeRA");
		req.body(data);

		// panggilan web service menggunakan method POST
		Response response = req.post();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(409); // Email telah terdaftar

	}

}
