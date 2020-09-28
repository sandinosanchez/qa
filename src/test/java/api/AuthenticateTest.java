package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class AuthenticateTest {

    @Test
    public void checkStatus(){

        given().
                auth().
                preemptive().
                basic("juanma_rovira@hotmail.com", "$2a$10$JfDk2j6ol19Ai2c.f2fcHuqdV703HZK2h7ZHtAzglEET1X2Lh8/Pe").
                when().
                get("//www.potterapi.com/v1/characters").
                then().
                assertThat().
                statusCode(200);


    /*    given().auth()
                .basic("juanma_rovira@hotmail.com",
                "$2a$10$JfDk2j6ol19Ai2c.f2fcHuqdV703HZK2h7ZHtAzglEET1X2Lh8/Pe")
                .when().get("https://www.potterapi.com/v1/key");*/

    }
}
