import io.restassured.RestAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class Motor_DE_Koble_Offer_Creation_no {


    private String koble_token;

    public String getkoble_token()
    {
        return  this.koble_token;
    }

    public void setKoble_token(String value)
    {
        this.koble_token=value;
    }


    String offer_id = "";


    //private static String token_type="Bearer";

    public static String apexRenoonostUrl="";


    public void setup() {
        RestAssured.baseURI ="https://api-stg.one-insurance.com/";
        this.koble_token= getKoble_Token();
    }

    @org.junit.Test
    public void CreateOffer() throws InterruptedException {
        CarFactory c = new CarFactory(true, "natural_person", "partial-comprehensive", "IT", false, false, false, false, false, false, false);
        String contract_body = c.setData();
        Response response =
                //String offer_id =
                given()
                        .accept("*/*")
                        .header("Authorization", "Bearer " + koble_token)
                        .header("Content-type", "application/json")
                        .cookies("cookie","__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                        .body(contract_body)
                        .when()
                        .post("/product/p_CarNewGermany/contract")
                        .then()
                        .log().ifError()
                        .extract()
                        .response();

        System.out.println(response.body().asString());

        //String offer_id = response.jsonPath().getString("offer_id");
        String external_id = response.jsonPath().getString("external_id");
        String premium_with_tax = response.jsonPath().getString("premium_with_tax");
        //Assert.assertNotNull(offer_id);
        Assert.assertNotNull(external_id);
        System.out.println(external_id);
        System.out.println(premium_with_tax);

        Thread.sleep(10000);

        Motor_DE_SF_Webhook_OfferCreation sf = new Motor_DE_SF_Webhook_OfferCreation();
        String offer_number = sf.getOfferNumberfromKobleExternalId(external_id);

        //GetSymassData_CH_V2 symass = new GetSymassData_CH_V2();
        //Response symass_response = symass.getSymassOfferData(offer_number);
        //Assert.assertNotNull(symass_response);






        //symass.setOffer_ID(offer_id);

        //symass.getSymassOfferData()
        //Assert.assertNotNull(offer_number);

    }




    public String getKoble_Token() {
        Response response = given()
                .config(RestAssured.config()
                        .encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                .header("Accept","application/json")
                .formParam("Content-Type","application/x-www-form-urlencoded")
                .formParam("grant_type","client_credentials")
                .formParam("client_id", "a3c9c03dde592fa8d59b04bef5cffc03")
                .formParam("client_secret","22e579a57f9144236317f569d49555f91f43a5e33d84b2799dced852f324861d")
                .cookies("cookie","__cfduid=daf2e82a75c7073034e750bfa2d4d91bf1618199056")
                .when()
                .post("https://api-stg.one-insurance.com/oauth/token")
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();

                if (response != null)
                {
                    System.out.println("koble token: " +response.jsonPath().getString("access_token"));
                }

                return response.jsonPath().getString("access_token");

    }

    public static String parseForOAuth2Code(Response response) {
        return response.jsonPath().getString("access_token");
    }



    String external_external_id ="";
    String gdvMessage003 = "{\"zeitstempel\":\"2021-01-11T09:13:32+00:00\",\"vuArbeitsgang\":{\"storno\":\"0\",\"mitteilungsart\":\"2\",\"aenderungVerwendungFahrzeug\":\"0\",\"aenderungVersicherung\":\"2\",\"aenderungMerkmalOldtimer\":null,\"aenderungKennzeichen\":\"3\",\"aenderungHalter\":\"0\",\"aenderungFahrzeugklasse\":\"0\"},\"versicherungsbestaetigungsnummer\":\"0000000\",\"versicherung\":{\"versicherungsunternehmensnummer\":\"9496\",\"versicherungsscheinnummer\":null,\"unternehmensart\":\"1\",\"interneVermerkeVersicherung\":\""+external_external_id+"\",\"geschaeftsstelleVersicherung\":\"000\",\"datumVersicherungsbeginn\":\"2021-01-11\",\"agenturVersicherung\":null},\"vbAblehnungsgrund\":null,\"nachrichtenkopf\":{\"nachrichtentyp\":\"GDV_VU_003\",\"listeTechnischeAbsenderinformationen\":[{\"zeitpunktNachrichtengenerierung\":\"2021-01-11T10:13:32+01:00\",\"softwareversion\":\"Evb.153.20200715-01\",\"kommunikationspartnerkennung\":\"GDV\"}],\"listeNachrichtenId\":[\"GDVDLevbprod2.13872.210111101332.000140237\",\"ZB033580_20210111101152695496\"],\"betriebsart\":\"PP\"},\"listeFehlerBei\":null,\"listeBedingung\":null,\"korrekturFahrzeugidentifizierungsnummer\":null,\"korrekturen\":null,\"kennzeichen\":{\"zeitpunktZuteilungKennzeichen\":\"2021-01-11T10:11:52+01:00\",\"merkmalWechselkennzeichen\":null,\"merkmalKennzeichenart\":\"ATS\",\"kennzeichen\":\"HK   282A\"},\"halter\":{\"vereinigung\":null,\"natuerlichePerson\":{\"vorname\":\"Vlad-Danut\",\"tagDerGeburt\":null,\"nachname\":\"Deac\",\"geschlecht\":\"m\"},\"juristischePerson\":null,\"halterAbweichendVonVersicherungsnehmer\":\"0\",\"anschrift\":{\"wohnort\":\"Com. Salatig\",\"strasse\":\"Jud.SJ Sat.Salatig\",\"staat\":\"RO\",\"postleitzahl\":\"457200\",\"hausnummer\":\"93\"}},\"fehlertyp\":null,\"fehlertext\":null,\"fahrzeug\":{\"verwendungFahrzeug\":\"O\",\"textFahrzeugklasse\":\"Fz.z.Pers.bef.b. 8 Spl. Schr\u00E4ghecklimousine\",\"textAufbau\":\"Schr\u00E4ghecklimousine\",\"schluesselVarianteVersion\":\"00327\",\"schluesselTyp\":\"ADK\",\"schluesselHersteller\":\"0603\",\"schluesselFahrzeugklasse\":\"M1\",\"schluesselAufbau\":\"AB\",\"nennleistungKw\":\"0077\",\"merkmalOldtimer\":null,\"merkmalKennzeichenart\":null,\"hubraum\":\"01896\",\"hersteller\":\"VOLKSWAGEN-VW\",\"fahrzeugidentifizierungsnummer\":\"WVWZZZ1KZ7B062498\",\"fahrzeugart\":\"2\"},\"datumNachversichererAb\":null,\"behoerde\":{\"zustaendigeBehoerdeZusatzziffer\":\"0\",\"zustaendigeBehoerdeKreisschluessel\":\"03358\",\"zeitpunktBearbeitung\":\"2021-01-19T10:11:52+01:00\"},\"anzeigeAblehnungsgrund\":null}";


}
