package dev.monx.expo.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import dev.monx.expo.model.ExpoResponse;
import dev.monx.expo.model.Message;
import dev.monx.expo.model.NotificationResponse;

@RegisterRestClient
public interface PushNotificationService {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("send")
    public ExpoResponse<NotificationResponse> send(Message message);
}
