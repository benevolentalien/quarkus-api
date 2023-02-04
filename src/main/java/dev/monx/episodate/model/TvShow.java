package dev.monx.episodate.model;

import java.time.LocalDate;
import java.util.Optional;

import dev.monx.util.DateTransform;

public class TvShow {
    private Long id;
    private String name;
    private Optional<String> start_date;
    private Optional<String> end_date;
    private String country;
    private String network;
    private String status;
    private String image_thumbnail_path;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image_thumbnail_path;
    }

    public void setImage_thumbnail_path(String image_thumbnail_path) {
        this.image_thumbnail_path = image_thumbnail_path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart_date(Optional<String> start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(Optional<String> end_date) {
        this.end_date = end_date;
    }

    public LocalDate getStartDate() {
        return DateTransform.convertToLocalDate(start_date);
    }

    public LocalDate getEndDate() {
        return DateTransform.convertToLocalDate(end_date);
    }

}
