package pruebas.test.org;

import java.io.IOException;
import okhttp3.*;
import org.apache.http.util.Asserts;
import org.json.JSONObject;

import java.io.IOException;

public class SalesforceScriptingForExecute {

  public static void main(String args[]) throws IOException {
  String token = new Authorization().getSalesforceAccessToken();
    String hyperscience_batch = "Database.executeBatch(new Hyperscience_Batch(), 50);";
    String cancel_contract_batch ="ONECancelContractBatch  batch = new ONECancelContractBatch ();\n" +
            "Database.executeBatch(batch , 1);";
    String activate_contract_batch = "ONEActiveContractBatch batch_1 = new ONEActiveContractBatch ();\n" +
            "Database.executeBatch(batch_1 , 1);";

    executeAnonymous(token,gdvMailboxProcessAndClean());

    executeAnonymous(token,cancel_contract_batch);

    executeAnonymous(token,hyperscience_batch);

    executeAnonymous(token,activate_contract_batch);


    //executeAnonymous(token,batchProcessForReSubmission("a0r3N000003MLtmQAG"));


  }

  public static String batchProcessForReSubmission(String contractId){
    return  "Attachmentwrapper__c acc = [select id, attachmentid__c, sendtohyperscience__C, parentid__c,successsenttohyperscience__C, type__c from attachmentwrapper__c where type__C='PreviousPolicyFile' and parentid__C = '"+contractId+"'];\n" +
            "acc.successsenttohyperscience__C = false;\n" +
            "update acc;";
  }

  public static  void executeAnonymous(String token, String batch) throws IOException {
    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("application/json");
    Request request = new Request.Builder()
            .url("https://one-insurance--fullbox.my.salesforce.com/services/data/v45.0/tooling/executeAnonymous/?anonymousBody=" + batch)
            .addHeader("Authorization", "Bearer " + token)
            .addHeader("Accept", "application/json")
            .addHeader("Content-Type", "application/json")
            .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());

  }

    public static  void executeQuery(String token, String query) throws IOException {
      OkHttpClient client = new OkHttpClient().newBuilder()
              .build();
      MediaType mediaType = MediaType.parse("application/json");
      Request request = new Request.Builder()
              .url("https://one-insurance--fullbox.my.salesforce.com/services/data/v51.0/query/?q="+query)
              .addHeader("Authorization", "Bearer " + token)
              .addHeader("Accept", "application/json")
              .addHeader("Content-Type", "application/json")
              .addHeader("Cookie", "BrowserId=zd3I2h_zEeuTBDHFf4zsXA; CookieConsentPolicy=0:0")
              .build();
      Response response = client.newCall(request).execute();
      System.out.println(response.body().string());
  }

  private static String gdvMailboxProcessAndClean()
  {
    return "Batch_GetGDVMailBox gdvmail = new Batch_GetGDVMailBox();\n" +
            "Database.executeBatch(gdvmail , 1);\n" +
            "\n" +
            "Batch_SendContractsToGDV gdvsend = new Batch_SendContractsToGDV();\n" +
            "Database.executeBatch(gdvsend , 1);\n" +
            "\n" +
            "Batch_ProcessGDVMailBox  gdvpro = new Batch_ProcessGDVMailBox ();\n" +
            "Database.executeBatch(gdvpro , 1);\n" +
            "\n" +
            "Batch_cleanGDVMailbox  gdvclean = new Batch_cleanGDVMailbox ();\n" +
            "Database.executeBatch(gdvclean , 1);\n";
  }


}
