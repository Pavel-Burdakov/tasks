package com.github.pavelburdakov.userapp.client.impl;

import com.github.pavelburdakov.userapp.client.UserClient;
import com.github.pavelburdakov.userapp.model.User;
import com.github.pavelburdakov.userapp.web.dto.CreateUserRequest;
import lombok.RequiredArgsConstructor;

import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserClientImpl implements UserClient {
    private static final String ROLE_USER = "ROLE_USER";

    private final Keycloak keycloakClient;
    @Value("${app.keycloak.realm}")
    private String realm;

    @Override
    public User createUser(CreateUserRequest request) {
        RealmResource realmResource = keycloakClient.realm(realm);

        UserRepresentation user = createUserRepresentation(request);

        setCredentials(user, request.getPassword());

        var response = realmResource.users().create(user);
        String userId = CreatedResponseUtil.getCreatedId(response);

        addRole(realmResource, userId);

        return new User(userId, request.getUsername(), request.getEmail());
    }

    @Override
    public List<User> getUsers() {
        RealmResource realmResource = keycloakClient.realm(realm);

        return realmResource.users().list().stream()
                .map(it -> new User(it.getId(), it.getUsername(), it.getEmail()))
                .toList();
    }


    private UserRepresentation createUserRepresentation(CreateUserRequest request) {
        UserRepresentation user = new UserRepresentation();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setEmailVerified(true);
        user.setEnabled(true);

        return user;
    }

    private void setCredentials(UserRepresentation user, String password) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);

        user.setCredentials(List.of(credential));
        user.setRealmRoles(List.of(ROLE_USER));
    }

    private void addRole(RealmResource realmResource, String userId) {
        UserResource userResource = realmResource.users().get(userId);
        var role = keycloakClient.realm(realm).roles().get(ROLE_USER).toRepresentation();

        userResource.roles().realmLevel().add(List.of(role));
    }

}
