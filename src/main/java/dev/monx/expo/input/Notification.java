package dev.monx.expo.input;

import org.eclipse.microprofile.graphql.Input;

@Input
public class Notification {
    public String title;
    public String body;
}
