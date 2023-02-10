package dev.monx.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ExceptionsEnum {
    EMPTY_STRING("String cannot be null");

    private String message;
}
