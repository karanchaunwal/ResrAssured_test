package test_02;

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

public class DiffWyToCreatReqPayload {
	
	@Test
	void createUsers() throws FileNotFoundException {
//		Req Payload{
//		    "name": "morpheus",
//		    "job": "leader"
//		}
//		
		//HashMap<String,Object> data=new HashMap();
		//or
		//HashMap data=new HashMap();
		//or
		//JSONObject data=new JSONObject();
		
		//data.put("name","Manoj");
		//data.put("job","Doctor");
		
		//or from an external file
		File fl=new File("C:\\Users\\ak282\\eclipse-workspace 2022\\RestrAssured_01\\dataa,json");
		FileReader fr=new FileReader(fl);
		JSONTokener jt =new JSONTokener(fr);
		JSONObject data=new JSONObject(jt);
			
		given()
		   .contentType("application/json")
		   .body(data.toString())
		   
		.when()
		   .post("https://reqres.in/api/users")
		   
		   
		.then()
		.statusCode(201)
	   .log().all();
		
	}
}
