package dev.monx.expo.model;

import java.util.Optional;

public class NotificationResponse {
    private String status;
    private Optional<String> message;
    private Optional<String> id;

    public Optional<String> getId() {
        return id;
    }

    public void setId(Optional<String> id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Optional<String> getMessage() {
        return message;
    }

    public void setMessage(Optional<String> message) {
        this.message = message;
    }

}
