package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathandQuerryparameter 
{
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void testQueryandPathParameter()
	{
		given()
		 .pathParam("mypath","users")   //path parameter
		 .queryParam("page", 2)        //query parameter
		 .queryParam("id", 5)         //query paramter
		
		.when()
		  .get("https://reqres.in/api/{mypath}")
		
		.then()
		 .statusCode(200)
		 .log().all();
		
	}

}
