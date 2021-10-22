package RestAutomation.Demo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;


import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class restassuredTests {
	

	
	@Test
	public void getwheatherDetails()
	{
		given()
		  .when()
		    .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending")
		  .then()
		      .statusCode(200)
		      .header("Content-Type", "application/json");
		     
		        
	}
 
	@Test
	public void listusers()
	{
		RestAssured.baseURI="https://reqres.in/api";
		given()
		 .when()
		    .get("/users?page=2")
		  .then()
		    .statusCode(200)
		    .body("data[1].id",equalTo(8));
		
	}
	
}
