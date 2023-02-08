package dev.monx.expo.model;

import java.util.Optional;

import lombok.Data;

@Data
public class NotificationResponse {
    private String status;
    private Optional<String> message;
    private Optional<String> id;

}
