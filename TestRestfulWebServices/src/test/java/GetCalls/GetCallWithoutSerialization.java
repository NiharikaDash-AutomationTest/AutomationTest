package GetCalls;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import UtilityClasses.DataPOJO;
import UtilityClasses.UsersPOJO;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetCallWithoutSerialization {

			
		
		
		@Test
		public void foo() throws URISyntaxException{
			

			given()
			.accept(ContentType.JSON)
			.when()
			.get(new URI("https://reqres.in/api/users?page=2"))
			.then()
			.assertThat()
			.body("page", equalTo(2),"total_pages",equalTo(2));
			 
		}
		
				
		
		
	

}
