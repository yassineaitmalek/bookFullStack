package com.yatmk.app.infrastructure.services.auth;

import java.util.Optional;
import java.util.Set;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.yatmk.app.infrastructure.config.properties.KeycloakProperties;
import com.yatmk.app.persistence.exception.config.ServerSideException;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class UserService {

  private final KeycloakProperties keycloakProperties;

  private final KeycloakSecurityContext keycloakSecurityContext;

  private final Keycloak keycloak;

  public AccessToken getAccessToken() {

    return keycloakSecurityContext.getToken();

  }

  public Set<String> getCurrentUserRoles() {

    return getAccessToken().getRealmAccess().getRoles();

  }

  public String getCurrentUserId() {

    return Try.of(this::getAccessToken)
        .map(AccessToken::getSubject)
        .onFailure(ServerSideException::reThrow)
        .get();

  }

  public Optional<UserRepresentation> getCurrentUser() {

    return getUserRepresentation(getCurrentUserId());
  }

  public UsersResource getUsersResources() {
    return keycloak.realm(keycloakProperties.getRealm()).users();
  }

  public Optional<UserResource> getUserResource(String userId) {
    return Optional.of(getUsersResources().get(userId));
  }

  public Optional<UserRepresentation> getUserRepresentation(String userId) {
    return getUserResource(userId)
        .map(e -> Optional.of(e.toRepresentation()))
        .orElseGet(Optional::empty);
  }

}
