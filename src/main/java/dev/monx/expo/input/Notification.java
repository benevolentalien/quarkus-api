package dev.monx.expo.input;

import org.eclipse.microprofile.graphql.Input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Input
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String body;

}
