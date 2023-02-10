package dev.monx.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dev.monx.google.TokenBuilder;
import dev.monx.helper.GqlTestHelpers;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class SearchUserTest {
    @Inject
    TokenBuilder tokenBuilder;
    String token;

    @BeforeEach
    void beforeEach() {
        token = tokenBuilder.getToken("123");
    }


    @Test
    void testSearchUser() throws IOException {
        var query = GqlTestHelpers.loadQueryAsJson("search.gql");

        given()
        .body(query)
        .header("authorization", token)
        .when()
        .post("/graphql")
        .then()
        .statusCode(200)
        .body(containsString("200"));

    }

    @Test
    void testSearchEmptyUser() throws IOException {
        var query = GqlTestHelpers.loadQueryAsJson("searchEmpty.gql");

        given()
        .body(query)
        .header("authorization", token)
        .when()
        .post("/graphql")
        .then()
        .statusCode(200)
        .body(containsString("String cannot be null"));

    }
}
