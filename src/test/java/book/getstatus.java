package book;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getstatus
{
	public static void main(String[] args)
	{
		RestAssured.baseURI="https://simple-books-api.glitch.me";   //setting up baseurl
		RequestSpecification req = RestAssured.given();             
		System.out.println(req);
		Response res = req.get("/status");                          //given Endpoint
		System.out.println(res);
		System.out.println(res.statusCode());                      
		Assert.assertTrue(res.statusCode()==200); 
		String STATus = JsonPath.from(res.asPrettyString()).get("status").toString();
		System.out.println(STATus);
		Assert.assertTrue(STATus.equals("OK"));
		

	}

}
