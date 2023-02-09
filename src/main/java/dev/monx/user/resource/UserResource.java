package dev.monx.user.resource;

import java.util.Set;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

import dev.monx.user.input.NewUser;
import dev.monx.user.model.User;
import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;

@GraphQLApi
@RequestScoped
public class UserResource {
    @Inject
    @Claim(standard = Claims.sub)
    String uid;

    @Mutation("register")
    @RolesAllowed("USER")
    @ReactiveTransactional
    public Uni<User> sendNotification(NewUser newUser) {
        var user = new User();
        user.uid = uid;
        user.followers = Set.of();
        user.following = Set.of();
        user.token = newUser.token;
        user.username = newUser.username;

        return user.persist();
    }

    @Mutation("updateToken")
    @RolesAllowed("USER")
    @ReactiveTransactional
    public Uni<User> updateToken(String token) {
        return User.updateToken(uid, token);
    }

    @Mutation("follow")
    @RolesAllowed("USER")
    @ReactiveTransactional
    public Uni<User> follow(Long id) {
        return User.follow(uid, id);
    }

    @Mutation("unfollow")
    @RolesAllowed("USER")
    @ReactiveTransactional
    public Uni<User> unfollow(Long id) {
        return User.unfollow(uid, id);
    }

    @Query("me")
    @RolesAllowed("USER")
    public Uni<User> me() {
        return User.findByUid(uid);
    }
}
