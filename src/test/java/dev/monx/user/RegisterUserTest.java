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
import dev.monx.user.input.NewUser;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class RegisterUserTest {
    @Inject
    TokenBuilder tokenBuilder;

    @Test
    void testRegisterUser() throws IOException {
        Map<String, Object> variables = new HashMap<>();
        variables.put("newUser", new NewUser("teste", "myToken"));

        var query = GqlTestHelpers.loadQueryAsJson("register.gql", variables);
        var token = tokenBuilder.getToken("1000");

        given()
                .body(query)
                .header("authorization", token)
                .when()
                .post("/graphql")
                .then()
                .statusCode(200)
                .body(containsString("teste"));
    }

}
