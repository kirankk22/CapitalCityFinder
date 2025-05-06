package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CapitalCityAPITest {

	public static void main(String[] args) {
		// Country to validate
		String country = "Republic of India";
		String expectedCapital = "New Delhi";

		// Set Base URI
		RestAssured.baseURI = "https://restcountries.com/v3.1";

		// Send GET request and validate
		Response response = given()
				.pathParam("country", country)
				.when()
					.get("/name/{country}")
				.then()
					.statusCode(200)
					.body("[0].capital[0]", equalTo(expectedCapital)).extract().response();

		// Print actual capital from response
		String actualCapital = response.jsonPath().getString("[0].capital[0]");
		System.out.println("Capital of " + country + " is: " + actualCapital);
	}

}
