package dev.monx.episodate.model;

import java.util.List;

public class TvShowDetails extends TvShow {
    private String image_path;
    private Double rating;
    private List<String> genres;
    private List<String> pictures;
    private Episode countdown;
    private List<Episode> episodes;

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public String getImage() {
        return image_path;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public Episode getCountdown() {
        return countdown;
    }

    public void setCountdown(Episode countdown) {
        this.countdown = countdown;
    }

}
