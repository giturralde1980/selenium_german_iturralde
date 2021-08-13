package Authorization;


import static io.restassured.RestAssured.given;

public class Authorization {

    private static String  symass_clientId = "6atudo1il38p04dttl7ihdrp6h";
    private static String symass_clientSecret = "140rheolv72rvl95e6u92eal20lu4udl49u3e88p86lk2a7pk6dh";
    private static String token_type="Bearer";


    public static String clientId = "3MVG9LzKxa43zqdKmeTTNjkqgD2ed98PsNLvSm6eKNn4wiA6uqy5x73ku0LPonGJ_cWSHKkx8kuBnA9YpaItI";
    public static String clientSecret = "8E5046134C677EF13EF163B08AF88BD04CB3416D145A3F44BF3F3E4872525959";
    public static String redirectUri = "";
    public static String scope = "*";
    public static String username = "automatic.user@one-insurance.eu.one.fullbox";
    public static String password = "FkmNvVsHUd9bEaM";
    public static String token = "weGaAxwMaeTuqYNWBppCF2Lb";

    public static String getSymassToken() {
        return
                given()
                        .accept("*/*")
                        .formParam("client_id", symass_clientId)
                        .formParam("client_secret",symass_clientSecret)
                        .formParam("grant_type","client_credentials")
                        .when()
                        .post("https://one-uat-symassapp.auth.eu-central-1.amazoncognito.com/oauth2/token")
                        .then()
                        .statusCode(200)
                        .log().ifError()
                        .extract()
                        .response().jsonPath().getString("access_token");
    }

    public static String getSalesforceToken() {
        return
                given()
                        .contentType("application/x-www-form-urlencoded")
                        .accept("*/*")
                        .formParam("response_type","json")
                        .formParam("client_id", clientId)
                        .formParam("client_secret",clientSecret)
                        .formParam("grant_type","password")
                        .formParam("username",username)
                        .formParam("password",password+token)
                        .when()
                        .post("https://test.salesforce.com/services/oauth2/token")
                        .then()
                        .statusCode(200)
                        .log().ifError()
                        .extract()
                        .response().jsonPath().getString("access_token");
    }
}
