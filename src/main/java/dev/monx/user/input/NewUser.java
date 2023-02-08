package dev.monx.user.input;

import org.eclipse.microprofile.graphql.Input;

@Input
public class NewUser {
    public String username;
    public String token;
}
