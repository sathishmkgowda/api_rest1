package basic_script;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;


@Test
public class Diffways_to_create_post_request_body extends pojo_post_request_Diffways_3_inherit
{
	//1]  Post request method using Hashmap
	//@Test(priority = 1)
	void testPostusingHashmap()
	{
		 HashMap data=new HashMap();
		 data.put("name", "scott");
		 data.put("location","ben");
		 data.put("phone", "123");
		 
		String courseArr []= {"C","C++"};
		
		data.put("courses",courseArr);
		
		
		given()
		 .contentType("application/json")
		 .body(data)
		 
		.when()
		  .post("http://localhost:3000/students")
		.then()
		 .statusCode(201)
		 .body("name",equalTo("scott"))
		 .body("location",equalTo("ben"))
		 .body("phone",equalTo("123"))
		 .body("courses[0]",equalTo("C"))
		 .body("courses[1]",equalTo("C++"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
	}
	
	//2] Post request body using org.json library
	//@Test(priority = 2)
	void testPostusingJsonlibrary()
	{
		 JSONObject data=new JSONObject();
		 data.put("name", "scott");
		 data.put("location","ben");
		 data.put("phone", "123");
		 
		String courseArr []= {"C","C++"};
		
		data.put("courses",courseArr);
		 
		given()
		 .contentType("application/json")
		 .body(data.toString())
		 
		.when()
		  .post("http://localhost:3000/students")
		.then()
		 .statusCode(201)
		 .body("name",equalTo("scott"))
		 .body("location",equalTo("ben"))
		 .body("phone",equalTo("123"))
		 .body("courses[0]",equalTo("C"))
		 .body("courses[1]",equalTo("C++"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
	}
	
	//3] post request body using POJO class
	//@Test
	void testPostusingPOJOclass()
	{
		 pojo_post_request_Diffways_3_inherit data2=new pojo_post_request_Diffways_3_inherit();
		// data2.setName("scott");
		 // data2.setLocation("ben");;
		 // data2.setPhone("123456");
		 String courseArr[]= {"C","C++"};
		 //data2.setCourses(courseArr); 	
		 
		given()
		 .contentType("application/json")
		 .body(data2)
		 
		.when()
		  .post("http://localhost:3000/students")
		.then()
		 .statusCode(201)
		 .body("name",equalTo("scott"))
		 .body("location",equalTo("ben"))
		 .body("phone",equalTo("123"))
		 .body("courses[0]",equalTo("C"))
		 .body("courses[1]",equalTo("C++"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
	}
	//4] post request body using JSONfile
	//@Test
	void testPostusingexternalJSONFile() throws FileNotFoundException
	{
		 File f=new File("//path of the file");
		 FileReader fr=new FileReader(f);
		 JSONTokener JT=new JSONTokener(fr);
		 JSONObject data=new JSONObject(JT);
		 
		given()
		 .contentType("application/json")
		 .body(data.toString())
		 
		.when()
		  .post("http://localhost:3000/students")
		.then()
		 .statusCode(201)
		 .body("name",equalTo("scott"))
		 .body("location",equalTo("ben"))
		 .body("phone",equalTo("123"))
		 .body("courses[0]",equalTo("C"))
		 .body("courses[1]",equalTo("C++"))
		 .header("Content-Type","application/json; charset=utf-8")
		 .log().all();
	}
	
	
	

}
