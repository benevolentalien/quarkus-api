package dev.monx.expo.input;

import org.eclipse.microprofile.graphql.Input;

import lombok.Data;

@Input
@Data
public class Notification {
    private String title;
    private String body;
}
