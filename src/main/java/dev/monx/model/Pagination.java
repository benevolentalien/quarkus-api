package dev.monx.model;

import java.util.List;

public class Pagination<T> {
  private Long page;
  private Long pages;
  private List<T> tv_shows;

  public Long getPage() {
    return page;
  }

  public void setPage(Long page) {
    this.page = page;
  }

  public Long getPages() {
    return pages;
  }

  public void setPages(Long pages) {
    this.pages = pages;
  }

  public void setTv_shows(List<T> tv_shows) {
    this.tv_shows = tv_shows;
  }

  public List<T> getTvShows() {
    return tv_shows;
}

  public void setTvShows(List<T> tvShows) {
    this.tv_shows = tvShows;
}

  
}
