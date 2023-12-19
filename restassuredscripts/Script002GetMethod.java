package restassuredscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Script002GetMethod {

		@Test(enabled =false)
		public void httpGetMethod() {
			Response res=RestAssured.get("https://reqres.in/api/users/2");
			System.out.println(res.asPrettyString());
			System.out.println(res.getBody().asPrettyString());
			System.out.println(res.getTime());
			
			
			System.out.println(res.getHeader("Content-Type"));
			int expected=200;
			int actual=res.getStatusCode();
			Assert.assertEquals(expected, actual);
			
		}
		
		@Test(enabled =false)
		public void httpGetMethod2() {
			Response res=RestAssured.get("https://reqres.in/api/users/3");
			System.out.println(res.asPrettyString());
			System.out.println(res.getBody().asPrettyString());
			System.out.println(res.getTime());
			
			
			System.out.println(res.getHeader("Content-Type"));
			int expected=200;
			int actual=res.getStatusCode();
			Assert.assertEquals(expected, actual);
			
		}
		
		@Test(enabled=false)
		public void httpGetMethod3() {
			Response res=RestAssured.get("https://www.redbus.in/");
			System.out.println(res.asPrettyString());
			System.out.println(res.getStatusCode());
			int expected,actual;
			expected=200;
			actual=res.getStatusCode();
			Assert.assertEquals(expected, actual);
		}
		@Test
		public void getBDDStyle() {
			RestAssured
			.given()
			.baseUri("https://reqres.in/api/users/2")
			.queryParam("page", "2")
			.when().get()
			.then()
			.statusCode(200)
			.log().all();
		}
}
