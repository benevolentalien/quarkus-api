package dev.monx.episodate.model;

import java.time.LocalDate;
import java.util.Optional;

import dev.monx.util.DateTransform;

public class Episode {
    private int season;
    private int episode;
    private String name;
    private Optional<String> air_date;

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getAirDate() {
        return DateTransform.convertToLocalDate(air_date);
    }

    public void setAir_date(Optional<String> air_date) {
        this.air_date = air_date;
    }

}
