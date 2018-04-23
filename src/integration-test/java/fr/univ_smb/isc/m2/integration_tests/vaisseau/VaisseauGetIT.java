package fr.univ_smb.isc.m2.integration_tests.vaisseau;

import fr.univ_smb.isc.m2.integration_tests.customer.RestAssuredTest;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;

public class VaisseauGetIT extends RestAssuredTest {

    @Test
    public void should_200_On_Existing_Clan() {
        given()
                .pathParam("vaisseauId", 1)
                .when()
                .get("/liste/Vaisseau/{vaisseauId}")
                .then()
                .statusCode(SC_OK);
    }


    @Test
    public void should_404_On_Non_Existing_Clan() {
        given()
                .pathParam("vaisseauId", 1024)
                .when()
                .get("/liste/Vaisseau/{vaisseauId}")
                .then()
                .statusCode(SC_NOT_FOUND);
    }
}