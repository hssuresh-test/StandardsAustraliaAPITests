import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;
import files.ReUsableMethods;


public class GetStateCode {

	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://api.weatherbit.io/";

		double lonVal=-73.935242;
		double latVal= 40.730610;
		String keyVal="872053f427e5470f9a6d34075c6b6034";
		
		//Get Place- State_code for the latitude and longitude
		
	String getPlaceResponse=	given().log().all().queryParam("lat", latVal).queryParam("lon", lonVal)
		.queryParam("key",keyVal)
		.when().get("v2.0/current")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
	String actualStateCode =js1.getString("data.state_code");
	System.out.println(actualStateCode);
	Assert.assertEquals(actualStateCode, "[NY]");
		
		
	}

}
