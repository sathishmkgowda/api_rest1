package day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class cookiesdemo
{
	//@Test
   void getcookiesinfo()
	{
		Response res = given()
		 
		 .when()
		  .get("https://www.google.com/");
		
		 // get single cookie info
		// String Cookie_value = res.getCookie("AEC");
		// System.out.println("value of cookie is==>>"+Cookie_value);
		
		//get all cookies info
		Map<String, String> Cookie_value = res.getCookies();
		// System.out.println(Cookie_value.keySet());     to get all the cookie key
		
		for (String k : Cookie_value.keySet())
		{
			String Cooki = res.getCookie("k");
			System.out.println(k+"         "+Cooki);
		}
	}
	

	

}
