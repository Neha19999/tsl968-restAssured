package Day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherInfo {
  @Test
  public void getWeatherInfo() {
	  /*Given> >pre condition like content type ,Authentication
	   * When  >user performs something
	   * Then> expected outcome from system
	   */
	  RestAssured.given()
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=776f2bdc4fa26e03ab5a26084f86d3a8")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  @Test(enabled =false ,description ="Getting weather API Information Generally ")
  public void getWeatherInfo2() {
	   Response res =RestAssured.given()
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=776f2bdc4fa26e03ab5a26084f86d3a8");
	  System.out.println(res.prettyPrint());
	   System.out.println(res.getTime());
	   System.out.println(res.getStatusCode());
	   System.out.println(res.getContentType());
	  
  }
  @Test(enabled =true ,description ="Getting weather API Information Generally ")
  public void getWeatherInfo3() {
	  Map< String , String > param = new HashMap<String ,String>();
	  param.put("q" ,  "Mumbai");
	  param.put("appid " ,"776f2bdc4fa26e03ab5a26084f86d3a8 ");
	   RestAssured.given()
			  // .queryParam("q","Mumbai")
			  // .queryParam("appid" , "776f2bdc4fa26e03ab5a26084f86d3a8")
	  .when()
	  .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=776f2bdc4fa26e03ab5a26084f86d3a8")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
}
}
