package fr.univ_smb.isc.m2.integration_tests.customer;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;

public class CustomerGetIT extends RestAssuredTest {

    @Test
    public void should_200_On_Existing_Customer() {
        given()
            .pathParam("customerId", 1)
        .when()
            .get("/customers/{customerId}")
        .then()
            .statusCode(SC_OK);
    }


    @Test
    public void should_404_On_Non_Existing_Customer() {
        given()
            .pathParam("customerId", 1024)
        .when()
            .get("/customers/{customerId}")
        .then()
            .statusCode(SC_NOT_FOUND);
    }

}
