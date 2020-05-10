package PutAndPatchCalls;

import static io.restassured.RestAssured.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import UtilityClasses.DataPOJO;
import UtilityClasses.UsersPOJO;
import io.restassured.http.ContentType;

public class PutAndPatchMethod {

	
	//Put call  : We need to send whole resource with updated field value in order to update a single field
	@Test
	public void foo(){
		
		
		UsersPOJO user=new UsersPOJO();
		List<DataPOJO> data = new ArrayList<DataPOJO>();
		DataPOJO datapojo= new DataPOJO();
		
		datapojo.setId("6789");
		datapojo.setEmail("niha.dashj@yahoo.com");  // we need to update only this field 
		datapojo.setFirst_name("cksdksd");
		datapojo.setLast_name("sgdhse");
		datapojo.setAvatar("dsds");
		
		data.add(datapojo);
		
		
		
		
		
		user.setPage("66");
		user.setPer_page("88");
		user.setTotal("99");
		user.setTotal_pages("55");
		user.setData(data);
		
		
	int n =	given()
		.when()
		.body(user)  // we are sending whole resource in body just for updating a single field  called email
		.put("https://reqres.in/api/users/2")
		.thenReturn()
		.statusCode();
		
		System.out.println("statuc code " + n);
		
		
	}
	
	
	
	//Patch call:  We DO NOT need to send whole resource with updated field value in order to update a single field. Just a single field
	//is to be updated/changed and sent along the body using patch call
	@Test
	public void xoo() throws URISyntaxException{
		
		
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
						
						
					int n = 	given()
						.when()
						.body(ele.setEmail("niharika.dash@gmail.com"))  // we send only single field called email to get updated
						.patch("https://reqres.in/api/users/2")
						.thenReturn()
						.statusCode();
					System.out.println(n);
						
						
					}
				}
		
	}
	
	
}
