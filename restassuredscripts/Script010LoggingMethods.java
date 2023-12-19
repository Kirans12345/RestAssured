package restassuredscripts;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
@Test
public class Script010LoggingMethods {
	String PMApiKey="90149396bf29b1623a4a4954a21009c4";
	public void method() {
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then()
		//.log().headers();
		//.log().all();
		//.log().ifError();
		.statusCode(200).log().cookies();
		
	}
}
