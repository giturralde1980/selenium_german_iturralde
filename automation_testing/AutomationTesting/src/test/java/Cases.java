import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;


public class Cases {

    private String case1 ="301_VBÜ Incorrect_No._1";
    private String case2_one ="301_VBÜ Incorrect_No._2_ONE";
    private String case2_other ="301_VBÜ Incorrect_No._2_Other";
    private String case3 ="301_VBÜ Incorrect_No._3";
    private String case4 ="301_VBÜ Incorrect_No._4";
    private String case5 ="301_VBÜ Incorrect_No._5";
    private String case6 ="301_VBÜ Incorrect_No._6";
    private String case7_Kennzeichen ="301_VBÜ Incorrect_No._7_Kennzeichen";
    private String case5_Kennzeichenart ="301_VBÜ Incorrect_No._7_Kennzeichenart";
    private String case6_Ausserbetriebsetzung ="301_VBÜ Incorrect_No._7_Ausserbetriebsetzung";


    private String salesforceToken;

    public Cases()
    {
       salesforceToken = new Authorization().getSalesforceToken();
    }


    @Test
    public void Test_CreateCaseWithCategory_114ContractCancellation_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));

        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println(case_response.prettyPeek());
        Assert.assertNotNull("response get newcategory__C: " + case_response.jsonPath().getString("id"));
        Assert.assertEquals("Contract_cancellation",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_Other_Result_NewCategory_NOT_Populated_OK()
    {
        String json_string = "";
        json_string="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"Other\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json_string)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .statusCode(200)
                        .log().ifError()
                        .extract()
                        .response();

        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        Assert.assertNull(case_response.jsonPath().getString("records[0].NewCategory__c"));
    }


    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_SonstigeAnderungenZulassung_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Sonstige Änderungen Zulassung\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));

        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        //Assert.assertNotNull("response get newcategory__C: " + case_response.jsonPath().getString("id"));
        //Assert.assertEquals("Contract_cancellation",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }







    @Test
    public void Test_CreateCaseWithCategory_301_VBU_Incorrect_No_1_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._1\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBU_Incorrect_No_2_ONE_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._2_ONE\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_2_Other_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._2_Other\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_3_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._3\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_4_Result_NewCategory__Populated_OK()
    {
        String json = "";
        System.out.println(this.salesforceToken);
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._4\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_5_Result_NewCategory__Populated_OK()
    {
        String json = "";
        System.out.println(this.salesforceToken);
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._5\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_6_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._6\"}";
        Response response = getInsertCaseResponse(json);

        String case_id= response.jsonPath().getString("id");

        Response case_response=getInsertedCaseInformation(case_id);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_7_Kennzeichen_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._7_Kennzeichen\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_7_Kennzeichen_Kennzeichenart_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._7_Kennzeichenart\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_301_VBÜ_Incorrect_No_7_Ausserbetriebsetzung_Result_NewCategory__Populated_OK()
    {
        String json = "";
        System.out.println(this.salesforceToken);
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"301_VBÜ Incorrect_No._7_Ausserbetriebsetzung\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }




    //Cases with 303_category
    private String case_dl_storno ="303_GDV_DL_Storno";
    private String doj = "303_GDV_DL_Neuzulassung";
    private String tres_1="303_GDV_DL_Halteradresse ohne Kennzeichenwechsel";
    private String tres_q="303_GDV_DL_Halterwechsel mit Kennzeichenwechsel";
    private String tres_v="303_GDV_DL_Halteradresse ohne Kennzeichenwechsel";
    private String tres_b="303_GDV_DL_Halteradresse mit Kennzeichenwechsel";
    private String tres_n="303_GDV_DL_Kennzeichenwechsel ohne Halterwechsel";
    private String tres_o="303_GDV_DL_Sonstige Änderungen Zulassung";
    private String tres_i="303_GDV_DL_Ausserbetriebsetzung";

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Storno_Result_NewCategory__Populated_OK()
    {
        String json = "";
        System.out.println(this.salesforceToken);
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Storno\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Neuzulassung_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Neuzulassung\"}";
        Response response = getInsertCaseResponse(json);
        String case_id= response.jsonPath().getString("id");

        Response case_response=getInsertedCaseInformation(case_id);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Halteradresse_ohne_Kennzeichenwechsel_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Halteradresse ohne Kennzeichenwechsel\"}";
        Response response =getInsertCaseResponse(json);
        String case_id= response.jsonPath().getString("id");
        Response case_response = getInsertedCaseInformation(case_id);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Halterwechsel_mit_Kennzeichenwechsel_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Halterwechsel mit Kennzeichenwechsel\"}";
        Response response =  getInsertCaseResponse(json);
        String case_id= response.jsonPath().getString("id");
        Response case_response=getInsertedCaseInformation(case_id);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Halteradresse_mit_Kennzeichenwechsel_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Halteradresse mit Kennzeichenwechsel\"}";
        Response response = getInsertCaseResponse(json);
        String case_id= response.jsonPath().getString("id");

        Response case_response = getInsertedCaseInformation(case_id);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Kennzeichenwechsel_ohne_Halterwechsel_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Kennzeichenwechsel ohne Halterwechsel\"}";
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();

        String case_id= response.jsonPath().getString("id");

        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Sonstige_Änderungen_Zulassung_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Sonstige Änderungen Zulassung\"}";
        Response response = getInsertCaseResponse(json);
        String case_id= response.jsonPath().getString("id");
        Response case_response = getInsertedCaseInformation(case_id);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_CreateCaseWithCategory_303_GDV_DL_Ausserbetriebsetzung_Result_NewCategory__Populated_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Web\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"303_GDV_DL_Ausserbetriebsetzung\"}";
        Response response=getInsertCaseResponse(json);
        String case_id= response.jsonPath().getString("id");
        Response case_response = getInsertedCaseInformation(case_id);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));
        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println("response get case from sf: "+case_response.prettyPeek());
        Assert.assertEquals("Motor_Authority",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    private Response getInsertedCaseInformation(String case_id)
    {
        String sql = "select newcategory__c from case where id='"+case_id+"'";
        Response case_response =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+sql)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
        return case_response;
    }

    private Response getInsertCaseResponse(String json)
    {
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization","Bearer " + this.salesforceToken)
                        .header("Content-type","application/json")
                        .header("Accept","application/json")
                        .body(json)
                        .when()
                        .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                        .then()
                        .statusCode(201)
                        .log().ifError()
                        .extract()
                        .response();
        return response;
    }
}
