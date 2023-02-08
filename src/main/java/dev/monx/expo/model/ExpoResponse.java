package dev.monx.expo.model;

import java.util.List;

import lombok.Data;

@Data
public class ExpoResponse<T> {
    private List<T> data;

}
