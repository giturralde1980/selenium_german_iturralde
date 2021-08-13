import Helpers.CaseHelper;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Case_Origin {

    private String salesforceToken;

    public Case_Origin(){
        salesforceToken = new Authorization().getSalesforceToken();
    }

    @Test
    public void Test_WIPO_OK()
    {
        String json = "";
        //json="{\"status\":\"Pending ONE\",\"category\":\"123 - Beitragsrechnung Hyperscience\",\"subject\":\"Daten (Brokerportal\\/ Vorjahresrechnung) stimmen nicht \\u00fcberein\",\"contract\":\"a0r3N000003MKMSQA4\",\"account\":\"0013N00000jAxtwQAC\",\"origin\":\"Internal\",\"description\":\"First Name - SF: Detlef | OCR: Detlef\\nLast Name - SF: Mielchen | OCR: Mielchen\\nStreet Name - SF: Dammort | OCR: Dammort\\nStreet Number - SF: 1a | OCR: 1A\\nPost Code - SF: 49635 | OCR: 49635\\nCity - SF: Badbergen | OCR: Badbergen\\nInsurancePolicyNumber - SF: 2-63.787.007-2 | OCR: 2-63.787.007-2\\n!!! Insurance - SF: null | OCR: DIALOG VERSICHERUNG AG\\n!!! Yearly Premium - SF: 26.93 | OCR: 323.15999999999997\\nLicencePlate - SF: OS-BU 551 | OCR: OS-BU 551\\nVinNumber - SF: WF0UXXGAJU3Y49641 | OCR: null\\nCurrency - SF: EUR | OCR: EUR\\nDateOfInvoiceContract - November 2020\\n\",\"reason\":{\"ocrResult\":[{\"mismatch\":true,\"field\":\"Yearly Premium\",\"expected\":\"145.5\",\"result\":\"333.75\"},{\"mismatch\":false,\"field\":\"Insurance Policy Number\",\"expected\":\"2-63.787.007-2\",\"result\":\"2-63.787.007-2\"}]}}";
        //JSONObject obj = new JSONObject(aux);
        //System.out.println(obj);

       json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Wipo\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
        CaseHelper helper = new CaseHelper();
        Response response = helper.getInsertCaseResopnse(json);

        String case_id= response.jsonPath().getString("id");

        String sql = "select origin from case where id='"+case_id+"'";

        Response case_response = helper.getQueryResponse(sql);

        Assert.assertNotNull(response);
        Assert.assertNotNull(response.jsonPath().getString("id"));
        Assert.assertEquals(true,response.jsonPath().getBoolean("success"));

        Assert.assertNotNull(case_response);
        System.out.println("response insert case: " +response.prettyPeek());
        System.out.println(case_response.prettyPeek());
        Assert.assertEquals("WIPO",case_response.jsonPath().getString("records[0].Origin"));
    }

    @Test
    public void Test_Internal_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Internal\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select origin from case where id='"+case_id+"'";
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
        Assert.assertEquals("Internal",case_response.jsonPath().getString("records[0].Origin"));
    }

    @Test
    public void Test_Customer_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Customer\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select origin from case where id='"+case_id+"'";
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
        Assert.assertEquals("Customer",case_response.jsonPath().getString("records[0].Origin"));
    }

    @Test
    public void Test_Phone_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Phone\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select origin from case where id='"+case_id+"'";
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
        Assert.assertEquals("Phone",case_response.jsonPath().getString("records[0].Origin"));
    }

    @Test
    public void Test_Email_OK()
    {
        String json = "";
        json="{\"AssetId\":null,\"SuppliedName\":null,\"SuppliedEmail\":null,\"SuppliedPhone\":null,\"SuppliedCompany\":null,\"Type\":\"Mechanical\",\"Status\":\"New\",\"Reason\":\"Equipment Design\",\"Origin\":\"Email\",\"Subject\":\"german testing from api sf\",\"Priority\":\"Medium\",\"Description\":null,\"Comments\":null,\"subject\":\"test api german\",\"category__C\":\"114 - Contract Cancellations\"}";
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

        String sql = "select origin from case where id='"+case_id+"'";
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
        Assert.assertEquals("Email",case_response.jsonPath().getString("records[0].Origin"));
    }
}
