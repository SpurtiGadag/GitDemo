package restassuredUtils;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.HashMap;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class restPostTest {
	public static HashMap hm= new HashMap();
@BeforeClass
public void postdata()
{
	hm.put("id",RestUtils.getid());
	hm.put("petId",RestUtils.petgetId1());
	hm.put("quantity", RestUtils.quantiy());
	hm.put("shipDate",RestUtils.getdate());
	hm.put("status", RestUtils.Status());
	hm.put("complete", RestUtils.complete());
	RestAssured.baseURI= "https://petstore.swagger.io/v2";
	RestAssured.basePath="/store/order";
}
	
	@Test
	public void testPost()
	{
		given()
		 .contentType("application/json")
		 .body(hm)
		.when()
		   .post()
		  .then()
		    .statusCode(200)
		    //.assertThat().body("status", equalTo("placed"));
		    .header("Content-Type", "application/json");
		    
		
		  
	}

}
