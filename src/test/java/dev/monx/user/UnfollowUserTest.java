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
class UnfollowUserTest {
    @Inject
    TokenBuilder tokenBuilder;

    @Test
    void testUnfollowUser() throws IOException {
        var query = GqlTestHelpers.loadQueryAsJson("unfollow.gql");
        var token = tokenBuilder.getToken("1234");

        given()
        .body(query)
        .header("authorization", token)
        .when()
        .post("/graphql")
        .then()
        .statusCode(200)
        .body(containsString("1234"));

    }
}
