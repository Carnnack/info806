package fr.univ_smb.isc.m2.integration_tests.customer;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class RestAssuredTest {

    @BeforeClass
    public static void setUp() {

        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(9135);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/api/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }

}
