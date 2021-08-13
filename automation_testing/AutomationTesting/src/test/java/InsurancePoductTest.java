import groovy.lang.GString;
import org.apache.http.HttpStatus;
import org.junit.Before;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.Base64;

public class InsurancePoductTest {

    private String userName="onebo-ms-gdv-ftp";
    private String pass="ej1ULf@s2i@g7#Z1DQlg";

    public static void setup() {
        RestAssured.baseURI ="https://onebo-ms-gdv-ftp.269518b54.eu-central-1.one-wefoxgroup.cloud";
    }

    public void Test_createZentralrufFile() {
        given()
                .accept("*/*")
                .contentType("application/json")
                .auth()
                .basic(userName, pass)
                .when()
                .post("/api/v1/jobs/createZentralrufFile")
                .then()
                .statusCode(202);

    }

    public void Test_createVbwfFile() {
        given()
                .accept("*/*")
                .contentType("application/json")
                .auth()
                .basic(userName, pass)
                .when()
                .post("/api/v1/jobs/createVwbFile")
                .then()
                .statusCode(202);

    }

    public void Test_readVbwfFile() {
        given()
                .accept("*/*")
                .contentType("application/json")
                .auth()
                .basic(userName, pass)
                .when()
                .post("/api/v1/jobs/readVwbFile")
                .then()
                .statusCode(202);

    }

    public void Test_pocessVbwFile() {
        given()
                .accept("*/*")
                .contentType("application/json")
                .auth()
                .basic(userName, pass)
                .when()
                .post("/api/v1/jobs/processVwbFile")
                .then()
                .statusCode(202);

    }

}
