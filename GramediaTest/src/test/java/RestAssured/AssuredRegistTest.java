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
	public void postGetRegistPage() {
//		RestAssured.baseURI = "https://www.gramedia.com/api/auth/register/"; //Method GET not allowed for this API
		RestAssured.baseURI = "https://www.gramedia.com/sign-up";

		// Request
		req = RestAssured.given();
//		req.header("Authorization",
//				"JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxNzQyNDY3LCJlbWFpbCI6InR1dG9yaWFsZGVzdGExMjNAZ21haWwuY29tIiwidXNlcm5hbWUiOiJ0dXRvcmlhbGRlc3RhMTIzQGdtYWlsLmNvbSIsImV4cCI6MTY1OTcyNjUxOCwib3JpZ19pYXQiOjE2NTg1MTY5MTgsImlzcyI6IkdSQU1FRElBIiwiZmlyc3RfbmFtZSI6InR1dG9yaWFsIiwibGFzdF9uYW1lIjoiZWluc3RlaW4ifQ.gtdt2LwwW5m1M7_veNFCA138p_qJxC3Pi5nhghIaXIU");

		// panggilan web service menggunakan method GET
		Response response = req.get();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200); 

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
		req.body(data);

		// panggilan web service menggunakan method POST
		Response response = req.post();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(409); //Error Email telah terdaftar

	}

}
