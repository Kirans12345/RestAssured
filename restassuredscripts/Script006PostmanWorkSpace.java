package restassuredscripts;
import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class Script006PostmanWorkSpace {
	
	//PMAK-65792df2adf0a16def96d724-866a2fb6d08538ba9868a796590c08679c
	
	@Test(priority = 1)
	public void apiKey() {
		String postmanAPIKey="PMAK-65792df2adf0a16def96d724-866a2fb6d08538ba9868a796590c08679c";
		
		
		given().baseUri("https://api.postman.com").basePath("/workspaces")
		.header("x-api-key",postmanAPIKey).when().get()
		.then().statusCode(200).log().all();
	
	}
	@Test(priority = 2)
	public void extractValueResponse() {
		String postmanAPIKey="PMAK-65792df2adf0a16def96d724-866a2fb6d08538ba9868a796590c08679c";
		
		String name=given().baseUri("https://api.postman.com").basePath("/workspaces")
		.header("x-api-key",postmanAPIKey).when().get()
		.then()
		.extract().path("workspaces[3].name");
		
		System.out.println("The name of workspace is : "+name);
		
		
	}
	@Test(priority = 3)
	public void JSON_path() {
		String postmanAPIKey="PMAK-65792df2adf0a16def96d724-866a2fb6d08538ba9868a796590c08679c";
		
		Response wname=given().baseUri("https://api.postman.com").basePath("/workspaces")
		.header("x-api-key",postmanAPIKey).when().get()
		.then()
		.extract().response();
		
		JsonPath json=new JsonPath(wname.asPrettyString());
		
		
		System.out.println("The response is : "+json.getString("workspaces[4]"));
	
	}	
	public void validateResponse() {
		given().baseUri("https://petstore.swagger.io'")
		.basePath(basePath)
		.when().get()
		.then().statusCode(200);
		
		
		//.body("username", equalTo("parikhmalay")),
		
				
	}
	
	@Test
	
	public void validate_hasItems() {
		String postmanAPIKey="PMAK-65792df2adf0a16def96d724-866a2fb6d08538ba9868a796590c08679c";

		given().baseUri("https://api.postman.com")
		.basePath("/workspaces")
		.header("x-api-key",postmanAPIKey )
		.when().get()
		.then().statusCode(200)
		// fetch the response body and validate if response includes correct values or not
		
		.body("workspaces.name", hasItems("My Workspace"),
			 "workspaces.type", hasItems( "personal"));
		
		
	}
}
