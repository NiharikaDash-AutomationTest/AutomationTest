package GetCalls;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.testng.annotations.Test;

import UtilityClasses.DataPOJO;
import UtilityClasses.UsersPOJO;
import io.restassured.http.ContentType;

public class GetCallUsingSerialization {


	@Test
	public void foo() throws URISyntaxException, IOException{
		
		
		UsersPOJO users = given()
		.accept(ContentType.JSON)
		.when()
		.get(new URI("https://reqres.in/api/users?page=2"))
		.as(UsersPOJO.class);
		
		
		System.out.println(users.getTotal());
		
		
		//printing nested objects
		List<DataPOJO> list = users.getData();
		for(DataPOJO ele : list){
			
			if(ele.getLast_name().contains("Edwards")){
				
				System.out.println(ele.getEmail());
			}
		}}
		
		



}
