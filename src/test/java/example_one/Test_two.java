package example_one;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class Test_two {
	@Test
	public void test_num_circuits() {

		given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
		// System.out.println(get("http://ergast.com/api/f1/2017/circuits.json").statusCode());
	}
}
