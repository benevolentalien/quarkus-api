package dev.monx.user.input;

import org.eclipse.microprofile.graphql.Input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Input
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewUser {
    private String username;
    private String token;

}
