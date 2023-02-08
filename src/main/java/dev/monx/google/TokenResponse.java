package dev.monx.google;

import lombok.Data;

@Data
public class TokenResponse {
    private String kind;

    private String idToken;

    private Boolean isNewUser;
}
