import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class Motor_CH_V2_ContractCreation {
    private static String  symass_clientId = "6atudo1il38p04dttl7ihdrp6h";
    private static String symass_clientSecret = "140rheolv72rvl95e6u92eal20lu4udl49u3e88p86lk2a7pk6dh";
    private static String token_type="Bearer";

    //Password: FkmNvVsHUd9bEaM
    //Token: weGaAxwMaeTuqYNWBppCF2Lb
    public static String clientId = "3MVG9LzKxa43zqdKmeTTNjkqgD2ed98PsNLvSm6eKNn4wiA6uqy5x73ku0LPonGJ_cWSHKkx8kuBnA9YpaItI";
    public static String clientSecret = "8E5046134C677EF13EF163B08AF88BD04CB3416D145A3F44BF3F3E4872525959";

    public static String redirectUri = "";
    public static String scope = "*";
    public static String username = "automatic.user@one-insurance.eu.one.fullbox";
    public static String password = "FkmNvVsHUd9bEaM";
    public static String token = "weGaAxwMaeTuqYNWBppCF2Lb";
    public static String sf_authorization_token ="";
    public static String sy_authorization_token ="";


    public static String apexRenoonostUrl="";

    private String contract_id;

    @org.junit.Before
    public void setup() {
        RestAssured.baseURI ="https://one-insurance--fullbox.my.salesforce.com/services/apexrest";
        sf_authorization_token=get_sf_auth_token();
        sy_authorization_token=get_sy_auth_token();
        contract_id="";
    }

    public String getContract_id()
    {
        return this.contract_id;
    }

    public void setContract_id(String _contract_id)
    {
        this.contract_id=_contract_id;
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
    public static String get_sf_auth_token() {
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
    public static String get_sy_auth_token() {
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
                        .extract()
                        .response().jsonPath().getString("access_token");
    }

    public static String parseForOAuth2Code(Response response) {
        return response.jsonPath().getString("access_token");
    }

    @org.junit.Test
    public void CreateCHV2_KH() {
        //String token = parseForOAuth2Code(getSf_Token());
        CarFactory c = new CarFactory(false,"natural_person","vehicle-liability","DE",false,false,false,false,false,false,false);
        given()
                .accept("*/*")
                .header("Authorization","Bearer " + sf_authorization_token)
                .header("Content-type","application/json")
                .header("Accept","application/json")
                .body(c.setData())
                .when()
                .post("/Contract/submit/v/0")
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }

    @org.junit.Test
    public void CreateCHV2_KH_Legal_Entity() {
        //String token = parseForOAuth2Code(getSf_Token());
        CarFactory c = new CarFactory(false,"legal_entity","fully-comprehensive","DE",true,false,true,true,false,false,true);
        given()
                .accept("*/*")
                .header("Authorization","Bearer " + sf_authorization_token)
                .header("Content-type","application/json")
                .header("Accept","application/json")
                .body(c.setData())
                .when()
                .post("/Contract/submit/v/0")
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }

    @org.junit.Test
    public void CreateCHV2_KH_Legal_Entity_refact() {
        //String token = parseForOAuth2Code(getSf_Token());
        CarFactory c = new CarFactory(false, "legal_entity", "fully-comprehensive", "DE", true, false, true, true, false, false, true);
        String body = c.setData();

        //JSONObject sf_inputs_insurances_request = new JSONObject(body);





        JSONArray request_inputs = new JSONObject(body).getJSONArray("inputs");



        Response sf_response = given().spec(getRequestData(body, sf_authorization_token)).post("/Contract/submit/v/0");
        Assert.assertTrue(sf_response.statusCode() == 200);
        //verify contract creation in symass
        Assert.assertTrue(sf_response.jsonPath().getString("contract_id") != null);
        //verify contract creation in sf
        Assert.assertTrue(sf_response.jsonPath().getString("contract_sfid") != null);
        this.setContract_id(sf_response.jsonPath().getString("contract_id"));
        //System.out.println(response.jsonPath().getString("contract_id"));


        //JSONObject sf_jsonBody = new JSONObject(sf_response.getBody().asString());
        //JSONArray sf_inputs = sf_jsonBody.getJSONArray("inputs");

        //Assert.assertTrue(sf_inputs != null);

        /*
        for (int i=0; i<inputs.length();i++)
        {
            if(inputs.getJSONObject(i).getString("name")=="product.motor.product-type")
            {
                Assert.assertEquals(inputs.getJSONObject(i).get("value"),c.getCar_product_type());
            }

            System.out.println("nombre: " + inputs.getJSONObject(i).getString("name") + " y valor: "+ inputs.getJSONObject(i).get("value"));
        }
        */

        Response sy_response = get_symass_data_response();
        Assert.assertNotNull(sy_response);
        System.out.println(sy_response.getBody().prettyPeek());
        JSONObject sy_jsonBody = new JSONObject(sy_response.getBody().asString());
        Assert.assertEquals(sf_response.jsonPath().getString("contract_id"), sy_response.jsonPath().getString("contractNumber"));
        JSONArray sy_inputs_insurances = sy_jsonBody.getJSONArray("insurances");
        Assert.assertTrue(sy_inputs_insurances != null);
        Assert.assertEquals(sf_response.jsonPath().getString("contract_id"), sy_response.jsonPath().getString("contractNumber"));

        for(int i=0;i<sy_inputs_insurances.length();i++)
        {

            System.out.println(sy_inputs_insurances.getJSONObject(i).getInt("id"));
            System.out.println(sy_inputs_insurances.getJSONObject(i).getString("productType"));
            
            //JSONArray sy_inputs_insurance = sy_inputs_insurances.getJSONArray(i);
            //JSONObject ob = sy_inputs_insurances.getJSONObject(i);
            //String arr = ob.getString("producttype");
        }
    }


    public RequestSpecification getRequestData(String body, String authorization_token)
    {
         RequestSpecification request =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + authorization_token)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .body(body);
         return request;
    }


    public Response get_symass_data_response() {
        //Response response = getCode();
        //String symass_access_token = getSymassToken(response);
       return given()
                .accept("*/*")
                .header("Authorization","Bearer " + get_sy_auth_token())
                .when()
                .get("https://symassuat.one-wefoxgroup.cloud/api/ch/contract/v1/contracts/"+this.contract_id)
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }



}
