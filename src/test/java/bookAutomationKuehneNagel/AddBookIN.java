package bookAutomationKuehneNagel;

import static io.restassured.RestAssured.given;

import org.junit.Before;
import org.junit.Test;

import Utils.ReusableMethods;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddBookIN {
	
		
	
	
	//removing the book from the list based on the data given in the body
	@Test
	public void removeBookfromTheList() {

				
		String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFsaTEyMzQiLCJwYXNzd29yZCI6IiFBbGkxMjM0IiwiaWF0IjoxNjczMTc5NjM3fQ.biLsxH3ybXrK5v2K1RsgnGVtJxX5-o76hH9lZB-_lQc\r\n"
				+ "";
		
		
		String filePath = "src/test/resources/GoRestData/BookRemoveReq.txt";
					
						Response responce = given().auth().oauth2(bearerToken)
						.contentType(ContentType.JSON)
						.header("content-type","application/json")
					  	.body(ReusableMethods.readFile(filePath))
						.when()
					    .delete("https://demoqa.com/BookStore/v1/Book");
								
	           System.out.println(responce.asPrettyString()); 
	           
	           int StatusCode = responce.getStatusCode();
				
				System.out.println("Current Status Code is ----> " + StatusCode);
					  
				
				if(StatusCode == 200 || StatusCode >= 200 && StatusCode <=205 ) {
					
					System.out.println("\nTest Passed\nBook has been successfully removed from the collection ");
					
				}
				else {
					
					System.out.println("\nTest Failed\nBook was not removed from the collection ");
				}
				
				
	}
	
	
		
	   //get method which will give you all the avaialbe books that are in your database
		@Before
		public void getAllTheBooks() {
	    	Response responce = given()
					.contentType(ContentType.JSON)
					.when()
					.get("https://demoqa.com/BookStore/v1/Books");
					
					System.out.println(responce.asPrettyString());
					
                    int StatusCode = responce.getStatusCode();
					
					System.out.println("Current Status Code is ----> " + StatusCode);
			
			
		}
	
	
	
		//Generating Bearer Token Based on the login credentials
		@Before
		public void generateToken() {
			                            //Generating Bearer Token Based on the login credentials
										//you can change the username and password or create a file and keep them in there as of your request Data
			String request = "{\r\n"
					+ "  \"userName\": \"BabaAli\",\r\n"
					+ "  \"password\": \"!BabaAli123\"\r\n"
					+ "}";
			
			
			Response responce = given()
					.contentType(ContentType.JSON)
					.header("content-type","application/json")
		    		.body(request)
					.when()
					.post("https://demoqa.com/Account/v1/GenerateToken");
					
					System.out.println(responce.asPrettyString());
					
                    int StatusCode = responce.getStatusCode();
					
					System.out.println("Current Status Code is ----> " + StatusCode);
			
		}
			
	
	
	
		//creating new user automation
		@Before
		public void generateUser() {
			
			
			                             //you can change the username and password which will create new users
			String request = "{\r\n"
					+ "  \"userName\": \"BabaAli\",\r\n"
					+ "  \"password\": \"!BabaAli123\"\r\n"
					+ "}";
			
			
			Response responce = given()
					.contentType(ContentType.JSON)
					.header("content-type","application/json")
		    		.body(request)
					.when()
					.post("https://demoqa.com/Account/v1/User");
					
					System.out.println(responce.asPrettyString());
					
					int StatusCode = responce.getStatusCode();
					
					System.out.println("Current Status Code is ----> " + StatusCode);
			
		}
	
	    
		
		//adding book in the list of my books automation 
		@Before	
		public void AddBook() {
			
			
			String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IkFsaTEyMzQiLCJwYXNzd29yZCI6IiFBbGkxMjM0IiwiaWF0IjoxNjczMTc5NjM3fQ.biLsxH3ybXrK5v2K1RsgnGVtJxX5-o76hH9lZB-_lQc";
			
		
			String filePath = "src/test/resources/GoRestData/RequestData.txt";
			
			
			
			Response resp = given().auth().oauth2(bearerToken)
			.contentType(ContentType.JSON)
			.header("content-type","application/json")
    		.body(ReusableMethods.readFile(filePath))
			.when()
			.post("https://demoqa.com/BookStore/v1/Books");
			
			System.out.println(resp.asPrettyString());
			
			
			int StatusCode = resp.getStatusCode();
			
			System.out.println("Current Status Code is ----> " + StatusCode);
			
			if(StatusCode == 200 || StatusCode >= 200 && StatusCode <=205 ) {
				
				System.out.println("\nTest Passed\nBook is added to collection ");
				
			}
			else {
				
				System.out.println("\nTest Failed\nBook was not added to collection ");
			}
				
			
		}

}
