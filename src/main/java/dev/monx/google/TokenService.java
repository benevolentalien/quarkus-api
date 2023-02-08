package dev.monx.google;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface TokenService {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("accounts:signInWithCustomToken")
    public TokenResponse getToken (@QueryParam("key") String key, PostBody jwt);
}
