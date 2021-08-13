

import io.restassured.RestAssured;
        import io.restassured.response.Response;
        import io.restassured.specification.RequestSpecification;

        import static io.restassured.RestAssured.given;

public class Motor_DE_Koble_Contract_Creation {
    public static String clientId = "a3c9c03dde592fa8d59b04bef5cffc03";
    public static String clientSecret = "22e579a57f9144236317f569d49555f91f43a5e33d84b2799dced852f324861d";

    public static String redirectUri = "";
    public static String scope = "*";
    public static String username = "automatic.user@one-insurance.eu.one.fullbox";
    public static String password = "z#Jju4%li$4Z39znUu9w";
    public static String token = "YtsqYkFRz37ZZqAv8Rzrfjidc";


    String offer_id = "";


    //private static String token_type="Bearer";

    public static String apexRenoonostUrl="";

    @org.junit.Before
    public void setup() {
        RestAssured.baseURI ="https://one-insurance--fullbox.my.salesforce.com/services/apexrest";
    }

    public static Response getkoble_Token() {
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
                        .response();
    }

    public static String parseForOAuth2Code(Response response) {
        return response.jsonPath().getString("access_token");
    }


}
