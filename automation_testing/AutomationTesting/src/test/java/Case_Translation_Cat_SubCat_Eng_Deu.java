import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Case_Translation_Cat_SubCat_Eng_Deu {


    private String salesforceToken;

    public Case_Translation_Cat_SubCat_Eng_Deu(){
        salesforceToken = new Authorization().getSalesforceToken();
    }

    @Test
    public void Test_Information_account_5_Certificate_Motor()
    {
        //liability contract
        String json = "";
        json="{\"contract__c\":\"a0r3N000003LzmHQAS\",\"subject\":\"test rest\",\"description\":\"bla bla rest\",\"accountId\":\"0013N00000fxZ0JQAU\",\"newcategory__c\":\"Information_account\"}\n";

        Response response =
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
        Assert.assertNotNull(case_response);
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("Motor",case_response.jsonPath().getString("records[0].NewCategory__c"));
    }
}
