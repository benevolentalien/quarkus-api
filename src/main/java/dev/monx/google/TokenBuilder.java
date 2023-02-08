package dev.monx.google;

import java.time.ZonedDateTime;
import java.util.Arrays;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class TokenBuilder {
    private final String privateKey = ConfigProvider.getConfig().getValue("FIREABASE_PRIVATE_KEY", String.class);
    private final String email = ConfigProvider.getConfig().getValue("FIREBASE_EMAIL", String.class);
    private final String apiKey = ConfigProvider.getConfig().getValue("FIREBASE_API_KEY", String.class);

    @Inject
    @RestClient
    private TokenService tokenService;

    public String getToken(String uid) {
        var now = ZonedDateTime.now().toInstant().toEpochMilli() / 1000;

        var token = Jwt
                .claim(Claims.iss, email)
                .claim(Claims.sub, email)
                .claim(Claims.iat, now)
                .claim(Claims.exp, now + 60 * 60)
                .claim("uid", uid)
                .claim("roles", Arrays.asList(new String[] { "USER" }))
                .claim(Claims.aud,
                        "https://identitytoolkit.googleapis.com/google.identity.identitytoolkit.v1.IdentityToolkit")
                .jws()
                .algorithm(SignatureAlgorithm.RS256)
                .sign("key.pem");

        var response = tokenService.getToken(apiKey, new PostBody(token, true));

        return "Bearer " + response.getIdToken();
    }
}
