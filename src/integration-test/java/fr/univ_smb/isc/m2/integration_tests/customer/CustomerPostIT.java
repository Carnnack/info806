package fr.univ_smb.isc.m2.integration_tests.customer;

import fr.univ_smb.isc.m2.domain.customer.Customer;
import fr.univ_smb.isc.m2.integration_tests.RetrieveUtil;
import io.restassured.RestAssured;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class CustomerPostIT extends RestAssuredTest  {

    @Test
    public void should_200_On_Customer_Creation_From_Map() {

        Map<String,String> customer = new HashMap<>();
        customer.put("firstName", "pipo");
        customer.put("lastName", "bimbo");

        given()
            .contentType("application/json; charset=UTF-8")
            .body(customer)
        .when()
            .post("/customers")
        .then()
            .statusCode(SC_OK);
    }

    @Test
    public void should_200_On_Customer_Creation_From_Bean() {

        given()
            .contentType("application/json; charset=UTF-8")
            .body(new Customer( 0, "pipo", "bimbo"))
        .when()
            .post("/customers")
        .then()
            .statusCode(SC_OK);

    }

}
