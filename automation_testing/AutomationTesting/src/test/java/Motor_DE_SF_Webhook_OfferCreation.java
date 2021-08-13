import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class Motor_DE_SF_Webhook_OfferCreation {
    public static String clientId = "3MVG9LzKxa43zqdKmeTTNjkqgD2ed98PsNLvSm6eKNn4wiA6uqy5x73ku0LPonGJ_cWSHKkx8kuBnA9YpaItI";
    public static String clientSecret = "8E5046134C677EF13EF163B08AF88BD04CB3416D145A3F44BF3F3E4872525959";

    public static String redirectUri = "";
    public static String scope = "*";
    public static String username = "automatic.user@one-insurance.eu.one.fullbox";
    public static String password = "FkmNvVsHUd9bEaM";
    public static String token = "weGaAxwMaeTuqYNWBppCF2Lb";


    String offer_id = "";


    //private static String token_type="Bearer";

    public static String apexRenoonostUrl="";

    @org.junit.Before
    public void setup() {
        RestAssured.baseURI ="https://one-insurance--fullbox.my.salesforce.com/services";
    }

    public static Response getSf_Token() {
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

    @org.junit.Test
    public void CreateOffer_webhook() {
        String token = parseForOAuth2Code(getSf_Token());
        CarFactory c = new CarFactory(true,"natural_person","partial-comprehensive","IT",false,false,false,false,false,false,false);
        Response response =
        //String offer_id =
            given()
                .accept("*/*")
                .header("Authorization","Bearer " + token)
                .header("Content-type","application/json")
                .header("Accept","application/json")
                .body(c.setData())
                .when()
                .post("/apexrest/offers/motor")
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();

        if(response != null)
        {
            String offer_id = response.jsonPath().getString("offer_id");
            String external_id = response.jsonPath().getString("external_id");
            String premium_with_tax = response.jsonPath().getString("premium_with_tax");

            //System.out.println(response.statusCode());
            //System.out.println(response.getBody().prettyPeek());

            System.out.println("symass "+offer_id);

            System.out.println("koble " +external_id);

            System.out.println("premium obtained: "+premium_with_tax);


            //Assert.assertNotNull(offerDataFromSymass);
            //System.out.println(offerDataFromSymass.prettyPeek());
            //offer_id":"A0008219
            //System.out.println(offer_id);
        }
    }

    public String getOfferNumberfromKobleExternalId(String external_id) {
        //String ext="WEFX-B4MCZ8WKCK";
        String token = parseForOAuth2Code(getSf_Token());
        //CarFactory c = new CarFactory(true, "natural_person", "partial-comprehensive", "IT", false, false, false, false, false, false, false);
        String sql = "select pendingcontractnumber__C from pendingcontract__C where externalid__C='"+external_id+"' limit 1";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + token)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        String pendingContractNumber = "";
        if (response!= null)
        {
               pendingContractNumber = response.jsonPath().getString("pendingcontractnumber__C");
               System.out.println(response.prettyPeek());
        }

        return pendingContractNumber;
    }






    @org.junit.Test
    public void test() {
        String ext="WEFX-B4MCZ8WKCK";
        String token = parseForOAuth2Code(getSf_Token());
        //CarFactory c = new CarFactory(true, "natural_person", "partial-comprehensive", "IT", false, false, false, false, false, false, false);
        String sql = "select pendingcontractnumber__C from pendingcontract__C where externalid__C='"+ext+"' limit 1";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + token)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        String pendingContractNumber = "";
        JSONObject resp = new JSONObject(response.body().asString());

        if (response!= null)
        {
            pendingContractNumber = response.jsonPath().getString("PendingContractNumber__c");


            System.out.println(response.prettyPeek());
        }

    }




    }
