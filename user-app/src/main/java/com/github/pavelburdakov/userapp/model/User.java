package com.github.pavelburdakov.userapp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * модель пользователя используется для добавления пользователей и
 * чтения польщователей из Keycloak
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private String id;

    private String username;

    private String email;

}
