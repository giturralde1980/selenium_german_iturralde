import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cases_Category_To_NewCatetgory_Mapping_Rules {

    private String salesforceToken;

    public Cases_Category_To_NewCatetgory_Mapping_Rules()
    {
        salesforceToken = new Authorization().getSalesforceToken();
    }

    @Test
    public void Test_Category_101PersonalData_to_NewCategory_NonTechnical()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003MEsIQAW\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000j9wwgQAA\",\"category__c\":\"101 - Personal Data Change\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Non_technical_change",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_102ContractDataChangee_to_NewCategory_TechnicalChange()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003MEsIQAW\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000j9wwgQAA\",\"category__c\":\"102 - Contract Data Change\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Technical_change",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_103PaymentsDataChange_to_NewCategory_Payments()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003MEsIQAW\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000j9wwgQAA\",\"category__c\":\"103 - Payment data change\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Payments",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }


    @Test
    public void Test_Category_105PaymentsReminder_to_NewCategory_Payments()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003MEsIQAW\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000j9wwgQAA\",\"category__c\":\"105 - Payment reminders\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C, newsubcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Payments",case_response.jsonPath().getString("records[0].NewCategory__c"));
        Assert.assertEquals("Payments",case_response.jsonPath().getString("records[0].NewSubCategory__c"));

    }

    @Test
    public void Test_Category_107ClaimsNotifications_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"107 - Claim notifications\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other (Create Claims)",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_108FeedbackComplaints_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"108 - Feedback/Complaint\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Complaints",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }


    @Test
    public void Test_Category_111GeneralQuestions_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"111 - General questions\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_112GeneralQuestions_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"112 - General questions\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_112InsuranceQuestions_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"112 - Insurance questions\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_113TechnicalQuestions_to_NewCategory_CustomerApp()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"113 - Technical questions\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Customer App",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_114ContractCancellations_to_NewCategory_ContractCancellation()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"114 - Contract Cancellations\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Contract_cancellation",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_115Marketing_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"115 - Marketing\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_116Legal_to_NewCategory_Complaints()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"116 - Legal\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Complaints",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_118Other_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"118 - Other\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C,newsubcategory__c from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_119Gebührenbescheid_to_NewCategory_Complaints()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"119 - Gebührenbescheid\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C,newsubcategory__c from case where id='"+case_id+"'";
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
        Assert.assertEquals("Complaints",case_response.jsonPath().getString("records[0].NewCategory__c"));
        Assert.assertEquals("Fee_notice",case_response.jsonPath().getString("records[0].NewSubCategory__c"));
    }



    @Test
    public void Test_Category_120Policycopyrequestfrombroker_to_NewCategory_3rdParty()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"120 - Policy request from broker\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Information 3rd party",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }


    @Test
    public void Test_Category_121DataErasure_to_NewCategory_Other()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"120 - Data Erasure\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_122His_to_NewCategory_Other()
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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Other",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_123Beitragsnachweis_to_NewCategory_Requestforinformationacount()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"123 - Beitragsnachweis\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Request for information (account)",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }

    @Test
    public void Test_Category_124Beitragsnachweis_to_NewCategory_Requestforinformationacount()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"category__c\":\"123 - Beitragsnachweis\",\"newsubcategory__c\":\"\"}\n";

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

        String sql = "select newcategory__C from case where id='"+case_id+"'";
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
        Assert.assertEquals("Request for information (account)",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }
}
