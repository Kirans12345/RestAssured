package restassuredscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script001SetUpCheck {
	
	
	@Test
	public void setupCheck() {
		Response res=RestAssured.get("https://reqres.in/api/users/2");
		
		System.out.println(res.asPrettyString());
		
		System.out.println(res.getStatusCode());
}
}
