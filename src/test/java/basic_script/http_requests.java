package basic_script;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class http_requests
{
	int id;
	
	
	@Test(priority = 1)
	void getusers()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		
		.then()
		  .statusCode(200)
		  .body("page",equalTo(2))
		  .log().all();
		
	}

	@Test(priority = 2)
	void createUser()
	{
		HashMap data=new HashMap();         //created the data by using hashmap 
		data.put("name","tiger");
		data.put("job","Hunting");
		 
		id=given()                              //we are sending the data
		   .contentType("application/json")
		   .body(data)
		
		.when()                             // this is a post request
		  .post("https://reqres.in/api/users")
		  .jsonPath().getInt("id");               //to capture the data
		
		//.then()                            //response validation
		//  .statusCode(201)
		//  .log().all();
	} 
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap data=new HashMap();        
		data.put("name","Eagle");
		data.put("job","Lone Survivor");
		 
		given()                              
		   .contentType("application/json")
		   .body(data)
		
		.when()                             
		  .put("https://reqres.in/api/users/"+id)
		.then()
		    .statusCode(200)
		    .log().all();
		  	
	}
	@Test(priority = 4)
	void deleteUser()
	{
		
		when()                             
		  .delete("https://reqres.in/api/users/"+id)
		.then()
		    .statusCode(204)
		    .log().all();
		    
		    
	}
}
