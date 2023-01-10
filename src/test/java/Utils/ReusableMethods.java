package Utils;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReusableMethods {
	
	
	
	

	public static void writeToFile(String data,String filePath) {
		
		
//		String data = "I am learning API automation in Yoll Academy";
//
//		String filePath = "src/test/resources/GoRestData/ResponseData.txt";

		File file = new File(filePath);

		try {
			FileUtils.writeStringToFile(file, data);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static String readFile(String filePath){

//		String filePath = "src/test/resources/GoRestData/RequestData.txt";
		
		
		File file = new File(filePath);
		
		String myData = null;
		try {
			myData = FileUtils.readFileToString(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myData;
		
		
		
	}
	

	
	public static String convertObjectToString(Object reqdata) throws JsonProcessingException {
		
		ObjectMapper objmapper = new ObjectMapper();
		
		String RequesttokenData = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(reqdata);
	
		return RequesttokenData;
		
		
		
	}
	
	
	
	

	
	
	
	public static Response submitTokenApiRequest(String RequestData) {
			
		Response resp = given()
				.contentType(ContentType.JSON)
				.body(RequestData)
				.when()
				.post("http://dev-mb.yoll.io/api/tokenauth/authenticate");
		
		resp.prettyPrint();
		
	return resp;
		
		
		
	}

}
