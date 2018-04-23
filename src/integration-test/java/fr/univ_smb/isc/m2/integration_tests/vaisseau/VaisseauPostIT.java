package fr.univ_smb.isc.m2.integration_tests.vaisseau;

import fr.univ_smb.isc.m2.domain.vaisseau.Vaisseau;
import fr.univ_smb.isc.m2.integration_tests.customer.RestAssuredTest;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class VaisseauPostIT extends RestAssuredTest {

    @Test
    public void should_200_On_Vaisseau_Creation_From_Map() {

        Map<String,String> vaisseau = new HashMap<>();
        vaisseau.put("id", "0");
        vaisseau.put("name", "Ritchie");
        vaisseau.put("type", "Blackmore");
        vaisseau.put("taille","100");
        vaisseau.put("capacitePort","1000");
        vaisseau.put("prix","10000");

        given()
                .contentType("application/json; charset=UTF-8")
                .body(vaisseau)
                .when()
                .post("/liste/Vaisseau")
                .then()
                .statusCode(SC_OK);
    }

    @Test
    public void should_200_On_Vaisseau_Creation_From_Bean() {

        given()
                .contentType("application/json; charset=UTF-8")
                .body(new Vaisseau(0,"Ritchie","Blackmore",100,1000,10000))
                .when()
                .post("/liste/Vaisseau")
                .then()
                .statusCode(SC_OK);
    }
}