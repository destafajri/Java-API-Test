package RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AssuredProfileTest {
	

	RequestSpecification req;
	ValidatableResponse vRes;

	@Test
	public void postGetProfile() {
		RestAssured.baseURI = "https://www.gramedia.com/api/user/profiles/";

		// Request
		req = RestAssured.given();
		req.header("Authorization",
				"JWT eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoxNzQyNDY3LCJlbWFpbCI6InR1dG9yaWFsZGVzdGExMjNAZ21haWwuY29tIiwidXNlcm5hbWUiOiJ0dXRvcmlhbGRlc3RhMTIzQGdtYWlsLmNvbSIsImV4cCI6MTY1OTcyNjUxOCwib3JpZ19pYXQiOjE2NTg1MTY5MTgsImlzcyI6IkdSQU1FRElBIiwiZmlyc3RfbmFtZSI6InR1dG9yaWFsIiwibGFzdF9uYW1lIjoiZWluc3RlaW4ifQ.gtdt2LwwW5m1M7_veNFCA138p_qJxC3Pi5nhghIaXIU");

		// panggilan web service menggunakan method GET
		Response response = req.get();

		response.prettyPrint();

		// Setup after
		vRes = response.then();
		vRes.statusCode(200); //response of success

	}


}
