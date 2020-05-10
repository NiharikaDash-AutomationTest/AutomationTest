package PostCalls;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PostCallWithoutSerialization {
	
	/*  DATA TO BE POSTED IN THE FOLLOWING JSON SCHEMA
	 * 
	 * {"page":1,"per_page":6,"total":12,"total_pages":2,
"data":[{"id":1,"email":"george.bluth@reqres.in","first_name":"George","last_name":"Bluth","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"},
{"id":2,"email":"janet.weaver@reqres.in","first_name":"Janet","last_name":"Weaver","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"},
{"id":3,"email":"emma.wong@reqres.in","first_name":"Emma","last_name":"Wong","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg"},
{"id":4,"email":"eve.holt@reqres.in","first_name":"Eve","last_name":"Holt","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/marcoramires/128.jpg"},
{"id":5,"email":"charles.morris@reqres.in","first_name":"Charles","last_name":"Morris","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/stephenmoon/128.jpg"},
{"id":6,"email":"tracey.ramos@reqres.in","first_name":"Tracey","last_name":"Ramos","avatar":"https://s3.amazonaws.com/uifaces/faces/twitter/bigmancho/128.jpg"}],
"ad":{"company":"StatusCode Weekly","url":"http://statuscode.org/","text":"A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things."}}*/

	
	
	
	HashMap map =  new HashMap();   //for storing container json object ex: page , per_page
	HashMap mapDataList =  new HashMap(); // for storing nested object list ex: id , email, first_name
	List <HashMap<?,?>> dataList = new ArrayList<HashMap<?,?>>();  //for storing above hashmap into a list ex : data
	
	
	@Test
	public void foo() throws URISyntaxException{
		
		
		//store container json object ex: page , per_page
		map.put("page", "8888888");
		map.put("per_page","33");
		map.put("total", "8800");
		map.put("total_pages","12223");
		
		
		
		//store nested object list ex: id , email, first_name
	mapDataList.put("id", "7788");
	mapDataList.put("email", "fff@gmail.com");
	mapDataList.put("first_name", "ffff");
	mapDataList.put("last_name", "llll");
	mapDataList.put("avatar", "hhhhhhhhhhh");
	
	
	//store nested object in a list "data"
	dataList.add(mapDataList);
	
	
	//store the "data" list into the main hashmap
	map.put("data", dataList);
	
	
	
	//create a new hashmap for storing "ad" field's nested key-value pairs like company , url an dthen store that hashmap into main hashmap
	 map.put("ad", new HashMap<String,String>() {{
         put("company", "test-test");
         put("url","ertyuio");
         put("text","testing software Api ");
         }});
	 
	 
	 
	 int n =given()
	 .when()
	 .body(map)
	 .post(new URI("https://reqres.in/api/users"))
	 .thenReturn()
	 .statusCode();
	
	
	System.out.println("status code is " + n);
		
		
			}


	
	
	
	
	
}
