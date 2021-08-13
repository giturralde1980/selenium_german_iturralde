import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cases_Assignment_Rules {
    private String salesforceToken;

    public Cases_Assignment_Rules()
    {
        salesforceToken = new Authorization().getSalesforceToken();
    }

    //Property Insurance

    @Test(priority = 0)
    public void Test_Rules_Technical_change_Coverage_Liability_PropertyInsurance()
    {
        String json = "";
        json="{\"contract__c\":\"a0r3N000003L45AQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fv5FFQAY\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Coverage_Liability\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 0)
    public void Test_Rules_Technical_change_Coverage_Household_PropertyInsurance()
    {
        String json = "";
        json="{\"contract__c\":\"a0r3N000003Lgc9QAC\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fwmnvQAA\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Coverage_Household\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 0)
    public void Test_Rules_Offer_application_request_Liability_PropertyInsurance()
    {
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Offer_application_request\",\"newsubcategory__c\":\"Liability\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 1)
    public void Test_Rules_Offer_application_request_Household_PropertyInsurance()
    {
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Offer_application_request\",\"newsubcategory__c\":\"Household\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }


    @Test(priority = 2)
    public void Test_Rules_Technical_change_Insured_Address_ProducGroupNOMotor_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003M2gQQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000iL8pvQAC\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Insured_Address\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 2)
    public void Test_Rules_Technical_change_Insured_Address_ProducGroupMotor_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Insured_Address\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 4)
    public void Test_Rules_Information_3rd_party_Insured_Address_ProducGroupMotor_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_3rd_party\",\"newsubcategory__c\":\"Police\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 5)
    public void Test_Rules_Information_3rd_party_Insured_Address_ProducGroupNOMotor_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003M2gQQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000iL8pvQAC\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Insured_Address\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test(priority = 6)
    public void Test_Rules_Information_general_RenewalProcess_ProductGroup_NO_Motor_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003M2gQQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000iL8pvQAC\",\"newcategory__c\":\"Information_general\",\"newsubcategory__c\":\"Renewal_Process\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test()
    public void Test_Rules_Applications_Contract_Creation_Property_Insurance_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Applications\",\"newsubcategory__c\":\"Contract_Creation_Property_Insurance\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test()
    public void Test_Rules_Applications_Service_Property_Insurance_PropertyInsurance()
    {
        //liability contract
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Applications\",\"newsubcategory__c\":\"Service_Property_Insurance\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Property Insurance",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    //payments
    @Test(groups = "Payment")
    public void Test_Rules_Payments_Payments()
    {
        //liability contract
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Payments\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Payment",case_response.jsonPath().getString("records[0].Owner.Name"));
    }


    //advisor administration

    @Test()
    public void Test_Broker_requests_Broker_requests()
    {
        //liability contract
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Broker_requests\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Advisor Administration",case_response.jsonPath().getString("records[0].Owner.Name"));
    }


    //Complaints & Customer Satisfaction

    @Test(groups = "Complaints & Customer Satisfaction")
    public void Test_Complaints_Complaints()
    {
        //liability contract
        String json = "";
        json="{\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"newcategory__c\":\"Complaints\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Complaints and Customer Satisfaction",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    //Motor

    @Test
    public void Test_Information_account_5_Certificate_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_account\",\"newsubcategory__c\":\"5_Certificate\"}\n";

        //_GERMAN PRUEBAS -> json="{\"Origin\":\"Api\",\"Priority\":\"Low\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Information_account_No_Claims_Discount_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"122 - HIS\",\"newsubcategory__c\":\"\"}\n";

        //json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_account\",\"newsubcategory__c\":\"No_Claims_Discount\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Information_account_Motor_Vehicle_Registration_Number_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_account\",\"newsubcategory__c\":\"Motor_Vehicle_Registration_Number\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Technical_change_Insured_Address_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Insured_Address\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Technical_change_Coverage_Motor_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Technical_change\",\"newsubcategory__c\":\"Coverage_Motor\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Motor_Authority_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003M96DQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000io3oFQAQ\",\"newcategory__c\":\"Motor_Authority\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Motor_Authority_GDV_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003M96DQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000io3oFQAQ\",\"newcategory__c\":\"Motor_Authority\",\"newsubcategory__c\":\"GDV\"}";
        //System.out.println(json);
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Motor_Authority_VVB_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003M96DQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000io3oFQAQ\",\"newcategory__c\":\"Motor_Authority\",\"newsubcategory__c\":\"VWB\"}";
        //System.out.println(json);
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

        String sql = "select owner.name, newsubcategory__c from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }



    @Test
    public void Test_Offer_application_request_Motor_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Offer_application_request\",\"newsubcategory__c\":\"Motor\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Applications_Contract_Creation_Motor_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Applications\",\"newsubcategory__c\":\"Contract_Creation_Motor\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Applications_Service_Motor_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Applications\",\"newsubcategory__c\":\"Service_Motor\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Information_3rd_party_Police_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_3rd_party\",\"newsubcategory__c\":\"Police\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }

    @Test
    public void Test_Information_general_Renewal_Process_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_general\",\"newsubcategory__c\":\"Renewal_Process\"}\n";
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

        String sql = "select owner.name from case where id='"+case_id+"'";
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].Owner.Name"));
    }
}
