import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import static io.restassured.RestAssured.*;
import files.ReUsableMethods;

public class GetForecast {

	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://api.weatherbit.io/";

		int postalcodeVal=28547;
		String keyVal="872053f427e5470f9a6d34075c6b6034";
		
		//Get Place- State_code for the latitude and longitude
		
	String getPlaceResponse=	given().log().all().queryParam("postal_code", postalcodeVal)
		.queryParam("key",keyVal)
		.when().get("v2.0/current")
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
	String actualTimestamp =js1.getString("data.datetime");
	String weatherdetails=js1.getString("data.weather");
	System.out.println(actualTimestamp);
	System.out.println(weatherdetails);
	
	
	
	
	
	
	
	
	

		
		
		
		
		
		
		
		
		
		
		
	}

}
