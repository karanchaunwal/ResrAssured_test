package test_01;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;   //we need to manually import these static packages - for given(), when() , and then()
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

//content or prerequisites 
//given()

//request type
//.when()     

//validations (or TestCases)
//.then()



public class HTTPRequests {
	
	int id;

	@Test   //using this annotation we can convert a method into a TC
	void getUsers() {
		
		given()
		
		.when()
		   .get("https://reqres.in/api/users?page=2")
		
		.then()
		   .statusCode(200)
		   .body("page",equalTo(2))
		   .log().all();
		
	 }
	
	
	
	
	@Test
	void createUsers() throws FileNotFoundException {
//		Req Payload{
//		    "name": "morpheus",
//		    "job": "leader"
//		}
//		
		HashMap<String,String> data=new HashMap();
		//or
		//HashMap data=new HashMap();
		//or
		//JSONObject data=new JSONObject();
		
		data.put("name","Manoj");
		data.put("job","Doctor");
		
		//or
//		File fl=new File("C:\\Users\\ak282\\eclipse-workspace 2022\\RestrAssured_01\\dataa,json");
//		FileReader fr=new FileReader(fl);
//		JSONTokener jt =new JSONTokener(fr);
//		JSONObject data=new JSONObject(jt);
//			
		given()
		   .contentType("application/json")
		   .body(data)
		   
		.when()
		   .post("https://reqres.in/api/users")
		   //.jsonPath().getInt("id");
		   
		.then()
		.statusCode(201)
		.log().all();
		
	}
	
	
	
	
	@Test
	void updateUser() {
		HashMap<String,Object> data=new HashMap();
		//or
		//HashMap data=new HashMap();
		data.put("name","Aman");
		data.put("job","Doctor2");
		
		given()
		   .contentType("application/json")
		   .body(data)
		   
		.when()
		   .put("https://reqres.in/api/users/"+id)
		   
		   
		.then()
		.statusCode(200)
		.log().all();
	}
	
	
//	@Test(priority=4)   //using this annotation we can convert a method into a TC
//	void getUsersAgain() {
//		
//		given()
//		
//		.when()
//		   .get("https://reqres.in/api/users?page=2")
//		
//		.then()
//		   .statusCode(200)
//		   .body("page",equalTo(2))
//		   .log().all();
//		
//	}
//	
	@Test(enabled=false)
	void deleteUser() {
		given()
		
		.when()
		  .delete("https://reqres.in/api/users/"+id)
			 
	    .then()
			 .statusCode(204)
			 .log().all();
	}
	
	
}

