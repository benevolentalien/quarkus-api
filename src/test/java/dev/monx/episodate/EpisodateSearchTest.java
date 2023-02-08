package dev.monx.episodate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import dev.monx.helper.GqlTestHelpers;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class EpisodateSearchTest {

    @Test
    void testHelloEndpoint() throws IOException {
        var query = GqlTestHelpers.loadQueryAsJson("search.gql");

        given()
                .body(query)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200)
                .body(containsString("Rick and Morty"));
    }

}