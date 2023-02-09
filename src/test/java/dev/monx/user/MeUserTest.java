package dev.monx.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.monx.google.TokenBuilder;
import dev.monx.helper.GqlTestHelpers;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class MeUserTest {
    @Inject
    TokenBuilder tokenBuilder;

    @Test
    void testMeUser() throws IOException {
        var query = GqlTestHelpers.loadQueryAsJson("me.gql");
        var token = tokenBuilder.getToken("123");

        given()
        .body(query)
        .header("authorization", token)
        .when()
        .post("/graphql")
        .then()
        .statusCode(200)
        .body(containsString("test"));

    }
}
