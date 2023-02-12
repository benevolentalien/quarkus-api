package dev.monx.expo.resource;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.monx.expo.input.Notification;
import dev.monx.expo.model.Message;
import dev.monx.expo.model.NotificationResponse;
import dev.monx.expo.service.PushNotificationService;
import dev.monx.user.model.User;

@GraphQLApi
@RequestScoped
public class PushNotificationResource {

    @Inject
    @RestClient
    PushNotificationService pushNotificationService;

    @Inject
    @Claim(standard = Claims.sub)
    String sub;

    // private final Logger logger = Logger.getLogger(PushNotificationResource.class);

    @Mutation("sendNotification")
    @RolesAllowed("USER")
    public List<NotificationResponse> sendNotification(Notification message) {
        var toSend = new Message();

        toSend.setBody(message.getBody());
        var user = User.findByUid(sub).await().atMost(Duration.ofSeconds(3));
        toSend.setTitle(user.username);

        toSend.setTo(user.followers.stream().map(u -> u.token).collect(Collectors.toList()));

        return pushNotificationService.send(toSend).getData();
    }
}
