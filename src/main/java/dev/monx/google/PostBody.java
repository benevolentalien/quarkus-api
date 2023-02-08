package dev.monx.google;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostBody {
    private String token;
    private Boolean returnSecureToken = true;
}
