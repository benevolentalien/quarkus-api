package dev.monx.user.model;

import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.jboss.logging.Logger;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.smallrye.mutiny.Uni;

@Entity(name = "users")
public class User extends PanacheEntity {
    private static final Logger logger = Logger.getLogger(User.class);

    @Column(unique = true, nullable = false)
    public String uid;

    @Column(unique = true, nullable = false)
    public String username;

    @Column(unique = true, nullable = false)
    public String token;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<User> following;

    @ManyToMany(mappedBy = "following", fetch = FetchType.EAGER)
    public Set<User> followers;

    public static Uni<User> findByUid(String uid) {
        return find("uid", uid).firstResult();
    }

    public static Uni<User> updateToken(String uid, String token) {
        return findByUid(uid).invoke(entity -> {
            logger.info(entity.username);
            entity.token = token;
        });
    }

    public static Uni<User> follow(String uid, Long id) {
        return findByUid(uid).invoke(user -> {
            var follows = new User();
            follows.id = id;
            user.following.add(follows);
        });
    }

    public static Uni<User> unfollow(String uid, Long id) {
        return findByUid(uid).invoke(user -> user.following = user.following.stream().filter(u -> !u.id.equals(id)).collect(Collectors.toSet()));
    }

}
