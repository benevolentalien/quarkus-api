package dev.monx.resource;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import dev.monx.model.Pagination;
import dev.monx.model.TvShow;
import dev.monx.model.TvShowDetails;
import dev.monx.service.EpisodateService;

@GraphQLApi
public class EpisodateResource {

    @Inject
    @RestClient
    EpisodateService episodateService;

    @Query("mostPopular")
    public Pagination<TvShow> mostPopular(@Name("page") Long page) {
        return episodateService.mostPopular(page);
    }

    @Query("search")
    public Pagination<TvShow> search(@Name("name") String name, @Name("page") Long page) {
        return episodateService.searchByName(name, page);
    }

    @Query("details")
    public TvShowDetails details(@Name("id") Long id) {
        return episodateService.details(id.toString()).getTvShow();
    }
}
