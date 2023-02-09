package dev.monx.user.input;

import org.eclipse.microprofile.graphql.Input;

import lombok.Data;

@Input
@Data
public class NewUser {
    private String username;
    private String token;
}
