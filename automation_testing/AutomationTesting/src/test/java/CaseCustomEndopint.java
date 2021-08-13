import Helpers.CaseHelper;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import java.io.FileReader;

import static io.restassured.RestAssured.given;

public class CaseCustomEndopint {


    private String salesforceToken;
    JSONParser parser;


    public CaseCustomEndopint(){

        salesforceToken = new Authorization().getSalesforceToken();
         parser = new JSONParser();
    }

    @Test
    public void HyperscienceInsertMissMatchCase() throws IOException, ParseException {
        CaseHelper caseHelper=new CaseHelper();
        Object obj = parser.parse(new FileReader("src/test/resources/caseCustomEndPointSalesforce.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject reason = (JSONObject) jsonObject.get("reason");
        JSONObject ocrResult = (JSONObject)  reason.get("ocrResult");
        ocrResult.put("ocrId", "testtest");
        JSONArray result = new JSONArray();
        HashMap mapa = new HashMap();
        mapa.put("result","pepe");
        mapa.put("field","Name");
        mapa.put("mismatch",true);
        mapa.put("expected","pepe");
        result.add(mapa);
        ocrResult.put("result",result);
        Response response = caseHelper.getInsertCaseResopnseCustomEndpoint(jsonObject.toJSONString());
        String insertedCaseId= response.jsonPath().getString("Id");
        Response ocrResponse = caseHelper.getQueryResponse("select id, name, expected__c,mismatch__C, field__C, result__C, ocrid__C, case__C from ocrresult__C where case__C='"+insertedCaseId+"'");
        Assert.assertEquals(ocrResponse.getStatusCode(),200);
        Assert.assertEquals(ocrResult.get("ocrId"),ocrResponse.jsonPath().getString("records[0].OcrId__c"));
        Assert.assertNotNull(ocrResponse.jsonPath().getString("records[0].Case__c"),"Case id must not be null");
    }
}
