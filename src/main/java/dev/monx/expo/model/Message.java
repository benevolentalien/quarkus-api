package dev.monx.expo.model;

import java.util.List;

import lombok.Data;

@Data
public class Message {
    private List<String> to;
    private String body;
    private String title;
    
}
