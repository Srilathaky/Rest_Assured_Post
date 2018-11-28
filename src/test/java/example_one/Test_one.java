package example_one;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_one {
	@Test
	public void ex_one() {
		/*
		 * This line uses a class called RestAssured to set up a request with
		 * the specified base URI. In our case the base URI is
		 * “http://restapi.demoqa.com/utilities/weather/city” . This is called
		 * the base URI because the is root address of the resource.
		 */
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		/*
		 * Every Request in Rest-Assured library is represented by an interface
		 * called RequestSpecification. This interface allows to modify the
		 * request, like adding headers or adding authentication details.
		 */
		 Response res = httprequest.request(Method.GET, "/Bangalore");
		//Response res = httprequest.get("/Bangalore");
		/*
		 * Now that RequestSpecification object is there, call the server to get
		 * the resource. This piece of code tells RequestSpecification to issue
		 * a request to the server.
		 */
		String res_body = res.getBody().asString();
		System.out.println(res.getStatusCode());
		System.out.println(res.getStatusLine());
		Assert.assertEquals("HTTP/1.1 200 OK", res.getStatusLine());
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(res.getContentType());
		System.out.println(res.header("Content-Type"));
		System.out.println(res.headers().toString());
		System.out.println(res_body);

	}

	@Test
	public void negative_test() {
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httprequest = RestAssured.given();
		Response res = httprequest.request(Method.GET, "/154446465464");
		Assert.assertEquals(res.getStatusCode(), 200);

	}
}
