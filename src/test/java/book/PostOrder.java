package book;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostOrder
{
	public static String getToken()
	{
		RestAssured.baseURI="https://simple-books-api.glitch.me";
		RequestSpecification req = RestAssured.given();
		Response res = req.header("Content-Type","application/json").body("{\r\n"
				+ "   \"clientName\": \"Aramba\",\r\n"
				+ "   \"clientEmail\": \"won@ex1.com\"\r\n"
				+ "}").post("/api-clients/");
		System.out.println(res.asPrettyString());
		String token = JsonPath.from(res.asPrettyString()).get("accessToken").toString();
		
		return token;
		   
	}
	
	public static void main(String[] args) 
	
	{
		File orderPayload=new File("src\\test\\resources\\SubmitOrder.json");
		String auth=getToken();
		
		RestAssured.baseURI="https://simple-books-api.glitch.me";
		RequestSpecification req = RestAssured.given();
	            Response res = req.header("Content-Type","application/json").header("Authorization","Bearer "+auth).body(orderPayload).post("orders");
	            System.out.println(res.asPrettyString());
		
	}

}
