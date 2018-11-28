package example_one;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test_Four {
	@Test
	public void assert_using_hamcrest() {
		baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		// basePath = "/Bangalore";

		given().when().get("/Bangalore").then().body("City", equalToIgnoringCase("Bangalore"));
	}

	@Test
	public void assert_using_hamcrest_all() {
		baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		String s = given().when().get("/Bangalore").body().asString();
		// Assert.assertTrue(s.contains("Bangalore"));
		given().when().get("/Bangalore").then().body("City", equalToIgnoringCase("Bangalore"), "Temperature",
				equalToIgnoringCase("28 Degree celsius"));
	}
}
