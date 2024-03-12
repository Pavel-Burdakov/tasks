package com.github.pavelburdakov.taskapp.client;

public interface KeycloakClient {
    String getToken(String clientId, String clientSecret);
}
