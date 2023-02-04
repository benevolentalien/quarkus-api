package dev.monx.expo.resource;

import java.util.List;

import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.monx.expo.model.Message;
import dev.monx.expo.model.NotificationResponse;
import dev.monx.expo.service.PushNotificationService;

@GraphQLApi
public class PushNotificationResource {
    
	@Inject
    @RestClient
    PushNotificationService pushNotificationService;

    @Mutation("sendNotification")
    public List<NotificationResponse> sendNotification(@Name("message") Message message) {
        return pushNotificationService.send(message).getData();
    }
}
