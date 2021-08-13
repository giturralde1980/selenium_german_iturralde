package pruebas.test.org;

import okhttp3.*;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class ContractCreation {

    private static String koble_token;
    public static DataFaker data;

    public ContractCreation() throws IOException {
        this.data=new DataFaker();
        this.koble_token=new Authorization().getKobleAccessToken();
    }


    private  void postKobleLiabilityContract() throws IOException {
        String body_ = data.contract_body("DE","liability");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,body_);
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_PrivateLiability/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + this.koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Response for person liability v6 contract creation: "+response.code());
    }

    public void CreateDEOffer() throws InterruptedException, IOException {

        String contract_body =data.contract_body("DE","offerDE");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,contract_body);
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_CarNewGermany/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + this.koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() != 200) {
            System.out.println("body request for error: " +response.body().string());
        }else
            System.out.println("oferta creada correctamente");

    }


    public void CreateCHOffer() throws InterruptedException, IOException {
        //CarFactory c = new CarFactory(true, "natural_person", "partial-comprehensive", "IT", false, false, false, false, false, false, false);
        String contract_body =data.contract_body("CH","csuite_comfort_ch");
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,contract_body);
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_CarCSuiteSwitzerland/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Response for motor offer (pending contract) creation ch: "+response.code());
    }

        public static void postKobleHouseholdContract() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, data.contract_body("DE","household"));
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_Household/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " +koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println("Response for person household v6 contract creation: "+response.code());
    }

    public static void postKobleSwitchContract() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,data.contract_body("DE","switch"));
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_YsMwxuaCF9RAcnDXTvkGwSWT/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        if (response.code()!= 200)
        {
            System.out.println("request body:" + data.contract_body("DE","switch"));

        }else
        {
            System.out.println("Response for switch motor contract creation: "+response.code());
        }
    }

    public static void postKobleClassicCsuiteContract() throws IOException {
        String json = data.contract_body("DE","csuite");
        //System.out.println(json);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .callTimeout(50, TimeUnit.SECONDS)
                .connectTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,json);
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_CarClassicGreenCombined/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " +koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        if (response.code() != 200)
        {
            //System.out.println(data.contract_body("DE","csuite"));
            System.out.println("MAL");
            System.out.println(json);

        }else{
            //System.out.println(data.contract_body("DE","csuite"));
            System.out.println("csuite motor contract: OK");
        }

    }
    public static void postKobleNewCarContract() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,data.contract_body("DE","new_car"));
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/:id/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.code());
    }

    public void postKobleLiabilityv2021Contract() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,data.contract_body("DE","liabilityv2021"));
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/product/p_PrivateLiability/contract")
                .method("POST", body)
                .addHeader("Authorization", "Bearer " + koble_token)
                .addHeader("Content-Type", "application/json")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
       // System.out.println(response.body().string());
        //System.out.println(data.contract_body("DE","liabilityv2021"));
        System.out.println(response.code());
    }
}
