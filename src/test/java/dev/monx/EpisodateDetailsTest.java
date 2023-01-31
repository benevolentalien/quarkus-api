package dev.monx;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import dev.monx.helper.GqlTestHelpers;

import static org.hamcrest.CoreMatchers.containsString;

import static io.restassured.RestAssured.given;

import java.io.IOException;

@QuarkusTest
public class EpisodateDetailsTest {

    @Test
    public void testHelloEndpoint() throws IOException {
        var query = GqlTestHelpers.loadQueryAsJson("details.gql");

        given()
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200)
                .body(containsString("Fernwood 2Night"));
    }

}