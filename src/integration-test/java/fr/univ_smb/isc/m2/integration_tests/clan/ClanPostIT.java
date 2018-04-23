package fr.univ_smb.isc.m2.integration_tests.clan;

import fr.univ_smb.isc.m2.domain.clan.Clan;
import fr.univ_smb.isc.m2.integration_tests.customer.RestAssuredTest;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

public class ClanPostIT extends RestAssuredTest {

    @Test
    public void should_200_On_Clan_Creation_From_Map() {

        Map<String,String> clan = new HashMap<>();
        clan.put("name", "hut");
        clan.put("localisation", "tatooin");
        clan.put("found","1000");

        given()
                .contentType("application/json; charset=UTF-8")
                .body(clan)
                .when()
                .post("/liste/clan")
                .then()
                .statusCode(SC_OK);
    }

    @Test
    public void should_200_On_Clan_Creation_From_Bean() {

        given()
                .contentType("application/json; charset=UTF-8")
                .body(new Clan( "hut", "tatooin",1000))
                .when()
                .post("/customers")
                .then()
                .statusCode(SC_OK);

    }
}