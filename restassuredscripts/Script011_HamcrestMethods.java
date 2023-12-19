package restassuredscripts;

import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.empty;

import org.testng.annotations.Test;

public class Script011_HamcrestMethods {
	@Test(priority = 1)
	public void containMethods()
	{
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", contains("My Workspace", "Phase-3-postman", "My Workspace-2", "My Workspace-1", "My Workspace-2"));
	}
	@Test
	public void emptyMethod() {
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name",empty());
	}
	@Test(priority='3')
	public void isNotemptyMethod() {
		
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured.
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", is(not(empty())));
		
		
	}
	@Test(priority='4')
	public void hasSizeMethod() {
		
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured.
		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key", PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", hasSize(76));
		
		
	}
	@Test
	public void everyItemStartwithMetod() {
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.visibility",everyItem(startsWith("per")));
	}
	@Test
	public void hasKeyMethod() {
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0]",hasKey("id"));
	}
	@Test
	public void hasValueMethod() {
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0]",hasValue("My Workspace"));
	}
	@Test
	public void hasEntryMethod() {
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces[0]",hasEntry("name","My Workspace"));
	}
	@Test
	public void anyOfWith() {
		String PMApiKey="PMAK-65811b17b316fa00556d8871-416e732df0d7713e63fe6ac246fdb30728";
		RestAssured
		.given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",PMApiKey)
		.when().get()
		.then().statusCode(200)
		.body("workspaces.name", anyOf(startsWith("Team"), containsString("My Workspace")));
	}
}
