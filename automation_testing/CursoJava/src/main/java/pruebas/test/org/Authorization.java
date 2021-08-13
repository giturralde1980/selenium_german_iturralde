package pruebas.test.org;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class Authorization {

    public Authorization()
    {

    }


    private static String  symass_clientId = "6atudo1il38p04dttl7ihdrp6h";
    private static String symass_clientSecret = "140rheolv72rvl95e6u92eal20lu4udl49u3e88p86lk2a7pk6dh";
    private static String token_type="Bearer";


    public static String clientId = "3MVG9LzKxa43zqdKmeTTNjkqgD2ed98PsNLvSm6eKNn4wiA6uqy5x73ku0LPonGJ_cWSHKkx8kuBnA9YpaItI";
    public static String clientSecret = "8E5046134C677EF13EF163B08AF88BD04CB3416D145A3F44BF3F3E4872525959";
    public static String redirectUri = "";
    public static String scope = "*";
    public static String username = "automatic.user@one-insurance.eu.one.fullbox";
    public static String password = "FkmNvVsHUd9bEaM";
    public static String token = "weGaAxwMaeTuqYNWBppCF2Lb";





    public String getKobleAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=a3c9c03dde592fa8d59b04bef5cffc03&client_secret=22e579a57f9144236317f569d49555f91f43a5e33d84b2799dced852f324861d");
        Request request = new Request.Builder()
                .url("https://api-stg.one-insurance.com/oauth/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject Jobject = new JSONObject(response.body().string());
        return Jobject.getString("access_token");
        //System.out.println(koble_token);
    }







    public String getSalesforceAccessToken() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "client_id=3MVG9LzKxa43zqdKmeTTNjkqgD2ed98PsNLvSm6eKNn4wiA6uqy5x73ku0LPonGJ_cWSHKkx8kuBnA9YpaItI&client_secret=8E5046134C677EF13EF163B08AF88BD04CB3416D145A3F44BF3F3E4872525959 &grant_type=password&username=automatic.user@one-insurance.eu.one.fullbox&password=FkmNvVsHUd9bEaMweGaAxwMaeTuqYNWBppCF2Lb");
        Request request = new Request.Builder()
                .url("https://test.salesforce.com/services/oauth2/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Cookie", "BrowserId=zd3I2h_zEeuTBDHFf4zsXA; CookieConsentPolicy=0:0")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject Jobject = new JSONObject(response.body().string());
        return Jobject.getString("access_token");
    }
}
