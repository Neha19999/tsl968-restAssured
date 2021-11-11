package Day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PositiveTest {
	String id;
  @Test(enabled =true, description = "for getting all Contact List")
  public void getAllContactList() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
	  
  }
  @Test(enabled = true,description= "Adding Contact ")
  public void addContact() {
	 JSONObject loc = new JSONObject();
	 loc.put("city" ,"Pune");
	 loc.put("country", "India");
	 
	 JSONObject emp = new JSONObject();
	 emp.put("jobTitile", "Automation Tester");
	 emp.put("company", "LTI");
	 
	 JSONObject ob = new JSONObject();
	 ob.put("firstName", "Mayank");
	 ob.put("lastName", "Sharma");
	 ob.put("email", "asmit@thikingtester.com");
	 ob.put("location",  loc);
	 ob.put("employer",  emp);
	 
	 id = given()
	 .header("Content-Type", "application/json ")
	 .body(ob.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(200)
	 .extract()
	 .jsonPath()
	 .get("_id");
	 System.out.println( "ID IS " + id);
	  }
  @Test(enabled = true, dependsOnMethods="addContact" ,description= "Getting Specific Contact")
  public void getSpecificContact() {
	 given()
	 .when()
	 .get("http://3.13.86.142:3000/contacts/"+ id)
	 .then()
	 .log()
	 .body()
	 .statusCode(200);
  }
  @Test(enabled = true, dependsOnMethods= "addContact" ,description= "updating the Contact")
  public void updateContact() {
		 JSONObject loc = new JSONObject();
		 loc.put("city" ,"Pune");
		 loc.put("country", "India");
		 
		 JSONObject emp = new JSONObject();
		 emp.put("jobTitile", "Automation Tester");
		 emp.put("company", "LTI");
		 
		 JSONObject ob = new JSONObject();
		 ob.put("firstName", "premchand");
		 ob.put("lastName", "Sharma");
		 ob.put("email", "asmit@thikingtester.com");
		 ob.put("location",  loc);
		 ob.put("employer",  emp);
		 given()
		 .header("Content-Type", "application/json ")
		 .body(ob.toJSONString())
		 .when()
		 .put("http://3.13.86.142:3000/contacts/" +id)
		 .then()
		 .log()
		 .body()
		 .statusCode(204);
  }
  @Test(enabled = true, dependsOnMethods="updateContact" ,description= "Deleting Specific Contact")
  public void deleteSpecificContact() {
  given()
	 
	 .when()
	 .delete("http://3.13.86.142:3000/contacts/" +id)
	 .then()
	 .log()
	 .body()
	 .statusCode(204);
}
}