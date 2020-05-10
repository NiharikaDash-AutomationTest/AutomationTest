package PostCalls;

import static io.restassured.RestAssured.given;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import UtilityClasses.DataPOJO;
import UtilityClasses.UsersPOJO;
import io.restassured.http.ContentType;

public class PostCallUsingSerialization {
	
	
	@Test
	public void foo() throws URISyntaxException{
		
		UsersPOJO user=new UsersPOJO();
		List<DataPOJO> data = new ArrayList<DataPOJO>();
		DataPOJO datapojo= new DataPOJO();
		
		datapojo.setId("6789");
		datapojo.setEmail("yudgaudjkas@sdjhd");
		datapojo.setFirst_name("cksdksd");
		datapojo.setLast_name("sgdhse");
		datapojo.setAvatar("dsds");
		
		data.add(datapojo);
		
		
		
		
		
		user.setPage("66");
		user.setPer_page("88");
		user.setTotal("99");
		user.setTotal_pages("55");
		user.setData(data);
		
		
		
		 
		 int n =given()
		 .when()
		 .body(user)
		 .post(new URI("https://reqres.in/api/users"))
		 .thenReturn()
		 .statusCode();
		
		
		System.out.println("status code is " + n);
			
	}
}
