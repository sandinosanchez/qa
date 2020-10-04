package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.openqa.selenium.json.Json;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.apache.hc.client5.http.async.methods.SimpleHttpRequests.get;


public class AuthenticateTest {

private String TOKEN = "$2a$10$JfDk2j6ol19Ai2c.f2fcHuqdV703HZK2h7ZHtAzglEET1X2Lh8/Pe";
private String url = "https://www.potterapi.com/v1/";
private static RequestSpecification requestSpec;

    @DataProvider(name = "housesData")
    public static Object[] houses() {
        return new Object[][] {
                {"Gryffindor"},
                {"Ravenclaw"},
                {"Slytherin"},
                {"Hufflepuff"},
        };
    }

   @BeforeClass
   public static void requestSpecification(){
       requestSpec = new RequestSpecBuilder().setBaseUri("https://www.potterapi.com/v1").build();
   }



    @Test
    public void checkStatus(){
        given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .queryParam("key", TOKEN)
                .get(url+"/characters")
                .then()
                .assertThat().statusCode(200);

    }

   @Test(dataProvider = "housesData")
    public void checkHouses(String houseId)
   {
             given()
                     .log().all().pathParam("houseId",houseId)
                .contentType(ContentType.JSON)
                .queryParam("key", TOKEN)
             .when()
               .get(url+"/houses/{houseId}").then().extract().body();
     

    }
}
