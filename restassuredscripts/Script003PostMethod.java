package restassuredscripts;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Script003PostMethod {
	@Test
	public void postMethod() {
		
		HashMap<String, String> map=new HashMap<>();
		map.put("name", "John");
		map.put("jobs", "QA Engineer");
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api/users")
		//.basePath("api/users")
		.contentType("application/json")
		.body(map)
		.when().post()
		.then()
		.statusCode(201)
		.log().all();
		
		
	}

}
