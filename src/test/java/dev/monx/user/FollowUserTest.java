package dev.monx.user;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import dev.monx.google.TokenBuilder;
import dev.monx.helper.GqlTestHelpers;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class FollowUserTest {
    @Inject
    TokenBuilder tokenBuilder;

    @Test
    void testFollowUser() throws IOException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", 300);

        var query = GqlTestHelpers.loadQueryAsJson("follow.gql", variables);
        var token = tokenBuilder.getToken("123");

        given()
                .body(query)
                .header("authorization", token)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200)
                .body(containsString("300"));

    }
}
