package example_one;

import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Test_Three {
	@Test
	public void rest_assured_test() {
		given().when().get("http://www.google.com").then().assertThat().statusCode(200);

		// given().when().get("http://www.google.com").then().statusCode(100);

		System.out.println(given().when().get("http://www.google.com").getBody());
		System.out.println(given().when().get("http://www.google.com").getStatusCode());

	}

	@Test
	public void get_response_in_json() {
		System.out.println(given().when().get("http://www.google.com").asString());//
		// REsponse
		// as
		// string
		System.out.println("--------------------------------------------------------------");
		System.out.println(given().accept(ContentType.JSON).when().get("http://www.google.com").asString());
	}

	@Test
	public void test_status_code() {
		System.out.println(given().get("http://www.google.com").getStatusCode());
		given().get("http://www.google.com").then().assertThat().statusCode(HttpStatus.SC_OK);

		int code = given().get("http://www.google.com").thenReturn().statusCode();
		Assert.assertEquals(HttpStatus.SC_OK, 200);
	}

	@Test
	public void headers() {
		Map<String, String> header = new HashMap<String, String>();
		header.put("Accept", "application/json");
		String res = given().headers(header).get("http://www.google.com").body().asString();
		System.out.println(res);
	}
}
