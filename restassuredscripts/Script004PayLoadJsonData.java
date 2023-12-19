package restassuredscripts;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class Script004PayLoadJsonData {
	int  responseid;
	@Test
	public void postPayloadUsingJSON() {
		
		JSONObject objbody=new JSONObject();
		objbody.put("name", "kirans");
		objbody.put("salary", "500000");
		objbody.put("age", "20");
		
		
		responseid=RestAssured
		.given().baseUri("https://dummy.restapiexample.com/api/v1/create")
		.contentType(ContentType.JSON)
		.body(objbody.toString())
		.when().post()
		.then()
		.statusCode(200)
		.body("data.name", equalTo("kirans"))
		.extract().path("data.id");
		System.out.println(responseid);
	}
	@Test
	public void delete() {
		RestAssured
		.given().baseUri("https://dummy.restapiexample.com/api/v1/delete/2")
		.when().delete();
	}

}
