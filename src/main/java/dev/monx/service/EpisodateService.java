package dev.monx.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.monx.model.Details;
import dev.monx.model.Pagination;
import dev.monx.model.TvShow;

@RegisterRestClient
public interface EpisodateService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("search")
    public Pagination<TvShow> searchByName(@QueryParam("q") String name, @QueryParam("page") Long page);

    @GET
    @Path("most-popular")
    public Pagination<TvShow> mostPopular(@QueryParam("page") Long page);

    @GET
    @Path("show-details")
    public Details details(@QueryParam("q") String q);
}
