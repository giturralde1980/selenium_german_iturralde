package Helpers;

import io.restassured.response.Response;
import Authorization.Authorization;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CaseHelper {

    private String salesforceToken;

    public CaseHelper()
    {
        this.salesforceToken=new Authorization().getSalesforceToken();;
    }

    public Response getInsertCaseResopnse(String json) {

        return given()
                .accept("*/*")
                .header("Authorization", "Bearer " + this.salesforceToken)
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(json)
                .when()
                .post("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/sobjects/Case")
                .then()
                .statusCode(201)
                .log().ifError()
                .extract()
                .response();
    }

    public JSONObject jsonObject() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/java/Resources/caseCustomEndPointSalesforce.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject reason = (JSONObject) jsonObject.get("reason");
        JSONObject ocrResult = (JSONObject)  reason.get("ocrResult");
        ocrResult.put("ocrId", "testtest");
        JSONArray result = new JSONArray();
        HashMap mapa = new HashMap();
        mapa.put("result","pepe");
        mapa.put("field","Name");
        mapa.put("mismatch",false);
        mapa.put("expected","pepe");
        result.add(mapa);
        mapa = new HashMap();
        mapa.put("result","lastName");
        mapa.put("field","Lastname");
        mapa.put("mismatch",false);
        mapa.put("expected","lastName");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","street");
        mapa.put("field","Street Name");
        mapa.put("mismatch",true);
        mapa.put("expected","adress");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","27a");
        mapa.put("field","Street Number");
        mapa.put("mismatch",true);
        mapa.put("expected","27");
        result.add(mapa);
        mapa = new HashMap();
        mapa.put("result","14178");
        mapa.put("field","Post Code");
        mapa.put("mismatch",false);
        mapa.put("expected","14178");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","Berlin");
        mapa.put("field","City");
        mapa.put("mismatch",false);
        mapa.put("expected","Berlin");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","2021");
        mapa.put("field","InsurancePolicyNumber");
        mapa.put("mismatch",false);
        mapa.put("expected","2021");
        result.add(mapa);
        ocrResult.put("result",result);

        mapa = new HashMap();
        mapa.put("result","HUK24");
        mapa.put("field","Insurance");
        mapa.put("mismatch",false);
        mapa.put("expected","HUK24");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","200");
        mapa.put("field","Yearly Premium");
        mapa.put("mismatch",true);
        mapa.put("expected","499");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","OMGOD1234");
        mapa.put("field","LicencePlate");
        mapa.put("mismatch",false);
        mapa.put("expected","OMGOD1234");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","€");
        mapa.put("field","Currency");
        mapa.put("mismatch",false);
        mapa.put("expected","€");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        mapa.put("result","July 2021");
        mapa.put("field","DateOfInvoiceContract");
        mapa.put("mismatch",false);
        mapa.put("expected","July 2021");
        result.add(mapa);
        ocrResult.put("result",result);
        mapa = new HashMap();
        return jsonObject;
    }

    public Response getInsertCaseResopnseCustomEndpoint(String json) {

        return given()
                .accept("*/*")
                .header("Authorization", "Bearer " + this.salesforceToken)
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(json)
                .when()
                .post("https://one-insurance--fullbox.my.salesforce.com/services/apexrest/Case/submit/v/0")
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }


    public Response getQueryResponse(String query)
    {
        return given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + this.salesforceToken)
                        .header("Content-type", "application/json")
                        .header("Accept", "application/json")
                        .when()
                        .get("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+ query)
                        .then()
                        .log().ifError()
                        .extract()
                        .response();
    }

}
