package dev.monx.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    Map<String, Object> variables;

    @BeforeEach
    void beforeEach() {
        token = tokenBuilder.getToken("123");
        variables = new HashMap<>();
    }

    @Test
    void testSearchUser() throws IOException {
        variables.put("username", "test2");
        var query = GqlTestHelpers.loadQueryAsJson("search.gql", variables);

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
        variables.put("username", "");
        var query = GqlTestHelpers.loadQueryAsJson("search.gql", variables);

        given()
                .body(query)
                .header("authorization", token)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200)
                .body(containsString(ExceptionsEnum.EMPTY_STRING.getMessage()));

    }
}
