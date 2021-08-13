package TestSteps;


import Helpers.CaseHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.mapper.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;


public class SalesforceSteps {
    Response caseResponse;
    Response ocrResponse;

    @Given("a case is created after a sumission ocr process finish with a mismatch")
    public void createcaseaftermismatc() throws IOException, ParseException {
        CaseHelper caseHelper=new CaseHelper();
        Object obj = caseHelper.jsonObject();
        caseResponse = caseHelper.getInsertCaseResopnseCustomEndpoint(obj.toString());
    }

    @When("a request is done against salesforce to ocrresult given  previous case")
    public void requestOcrResultToSalesforceByCaseId()
    {
        CaseHelper caseHelper= new CaseHelper();
        String insertedCaseId= caseResponse.jsonPath().getString("Id");
        System.out.println(insertedCaseId);
        String query="select id, name, expected__c,mismatch__C, field__C, result__C, ocrid__C, case__C from ocrresult__C where case__C='"+insertedCaseId+"'";
        ocrResponse = caseHelper.getQueryResponse(query);
    }

    @Then("ocrresult is obtained and matches with case request")
    public void thirdcond()
    {
        Assert.assertEquals(ocrResponse.getStatusCode(),200);
        Assert.assertNotNull(ocrResponse.jsonPath().getString("records[0].Case__c"),"Case id must not be null");
    }

    @Then("ocrresult is obtained and matches with case request two")
    public void thirdcond2()
    {
        Assert.assertEquals(ocrResponse.getStatusCode(),200);
        Assert.assertNull(ocrResponse.jsonPath().getString("records[0].Case__c"),"Case id must not be null");
    }


    @Given("a salesforce case id {string} is given")
    public void parameter()
    {

    }




}
