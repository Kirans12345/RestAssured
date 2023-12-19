package restassuredscripts;


import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredProject {
	

	
	@Test(priority = 1)
	public void baseURL() {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api");
		
	}
	
	@Test(priority = 2)
	public void RegisterUser() {
		
		JSONObject objbody=new JSONObject();
		objbody.put("id", "7");
		objbody.put("email", "Tester");
		objbody.put("first_name", "Kiran");
		objbody.put("last_name", "S");
		objbody.put("avatar", "https://reqres.in/img/faces/7-image.jpg");
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api")
		.contentType(ContentType.JSON)
		//.contentType("application/json")
		.body(objbody)
		.when().post();
		//.then()
		//.statusCode(200);

	}
	
	@Test(priority = 3)
	public void GetUser() {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api")
		.basePath("/users")
		.when().get()
		.then()
		.log().all();
		//.statusCode(200);

	}
	
	@Test(priority = 4)
	public void TestUser() {
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api")
		.basePath("/unknown")
		.when().get()
		.then()
		.statusCode(200)
		.log()
		//.all()
		.headers();
		//.log().ifError();
		//.cookies();
		
		
		;

	}

}
