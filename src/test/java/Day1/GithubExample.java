package Day1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class GithubExample {
  @Test(enabled=false , description =" Getting all repositories")
  public void getAllRepo() {
	  given()
	  .auth()
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
  }
  @Test(enabled =true , description ="Adding repository")
  public void addRepository() {
	 JSONObject js= new JSONObject();
	 js.put("name", "tsl968-restAssured8");
	 
	 js.put("description", " I am creasted by  RestAssured");
	 js.put("homepage", "http://github.com/Neha19999");
	 
	 given()
	 .auth()
	 .oauth2("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")
	.header("Content-Type" , "application/json")
	.body(js.toJSONString())
	  .when()
	  .post("https://api.github.com/user/repos")
	  .then()
	  .log()
	  .body()
	  .statusCode(201)
	  .time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);
  }
}
