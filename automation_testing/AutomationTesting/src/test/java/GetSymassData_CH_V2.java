import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.junit.Ignore;

import io.restassured.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetSymassData_CH_V2 {

    private static String  oauth2Url ="https://one-uat-symassapp.auth.eu-central-1.amazoncognito.com";
    private static String  clientId = "6atudo1il38p04dttl7ihdrp6h";
    private static String clientSecret = "140rheolv72rvl95e6u92eal20lu4udl49u3e88p86lk2a7pk6dh";
    private static String token_type="Bearer";




    private static String username = "automatic.user@one-insurance.eu.one.fullbox";
    private static String password = "z#Jju4%li$4Z39znUu9w";
    //public static String token = "YtsqYkFRz37ZZqAv8Rzrfjidc";


    private static String access_token;
    private static String instance_url;
    private String contract_id;
    private String offer_id;




    //Inputs to copy-paste

    //ONE - Cognito AWS
   // http://localhost:3000/oauth2/idpresponse
    //{{oauth2host}}/oauth2/authorize
    //{{oauth2host}}/oauth2/token
    //{{clientId}}
    //{{secret}}



    @Test
    public void getCodetoken() {

                given()
                        .accept("*/*")
                        .formParam("client_id", clientId)
                        .formParam("client_secret",clientSecret)
                        .formParam("grant_type","client_credentials")
                        .when()
                        .post("https://one-uat-symassapp.auth.eu-central-1.amazoncognito.com/oauth2/token")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response().toString();
    }

    public static Response getCode() {
        return
                given()
                        .accept("*/*")
                        .formParam("client_id", clientId)
                        .formParam("client_secret",clientSecret)
                        .formParam("grant_type","client_credentials")
                        .when()
                        .post("https://one-uat-symassapp.auth.eu-central-1.amazoncognito.com/oauth2/token")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();
    }

    public static String getSymassToken(Response response) {
        return response.jsonPath().getString("access_token");
    }

@Test
    public void getSymassContrctData() {
        Response response = getCode();
        String token = getSymassToken(response);
        System.out.println(token);


        given()
                .accept("*/*")
                .header("Authorization","Bearer " + token)
                .when()
                .get("https://symassuat.one-wefoxgroup.cloud/api/ch/contract/v1/contracts/"+this.contract_id)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();
    }

    public Response getSymassOfferData() {
        Response response = getCode();
        String token = getSymassToken(response);
        System.out.println("symass token: "+token);
        return given()
                .accept("*/*")
                .header("Authorization","Bearer " + token)
                .when()
                .get("https://symassuat.one-wefoxgroup.cloud/api/de/contract/v1/offers/"+offer_id)
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }



}
