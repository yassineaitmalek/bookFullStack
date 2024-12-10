package com.yatmk.app.infrastructure.services.auth;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.yatmk.app.common.utility.StringTemplate;
import com.yatmk.app.infrastructure.config.properties.KeycloakProperties;
import com.yatmk.app.persistence.dto.auth.RefreshTokenDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class AuthentificationService {

  private final KeycloakProperties keycloakProperties;

  private final WebClient webClient;

  public static final String CLIENT_ID = "client_id";

  public static final String CLIENT_SECRET = "client_secret";

  public static final String REFRESH_TOKEN = "refresh_token";

  public static final String AUTH_URL = "authUrl";

  public static final String REALM_STRING = "realm";

  public static final String GRANT_TYPE = "grant_type";

  private Keycloak buildKeyClock(String username, String password) {
    return KeycloakBuilder.builder()
        .realm(keycloakProperties.getRealm())
        .clientId(keycloakProperties.getResource())
        .serverUrl(keycloakProperties.getAuthServerUrl())
        .grantType(OAuth2Constants.PASSWORD)
        .clientSecret(keycloakProperties.getSecret())
        .username(username)
        .password(password)
        .build();
  }

  public AccessTokenResponse login(String username, String password) {

    log.info("username : {} is trying to connect", username);
    return buildKeyClock(username, password)
        .tokenManager()
        .getAccessToken();

  }

  public Void logout(RefreshTokenDTO refreshTokenDTO) {

    log.info("refresh token logging out : {} ", refreshTokenDTO.getRefreshToken());
    String url = StringTemplate.template("${authUrl}/realms/${realm}/protocol/openid-connect/logout")
        .addParameter(AUTH_URL, keycloakProperties.getAuthServerUrl())
        .addParameter(REALM_STRING, keycloakProperties.getRealm())
        .build();
    MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
    formData.add(CLIENT_ID, keycloakProperties.getResource());
    formData.add(CLIENT_SECRET, keycloakProperties.getSecret());
    formData.add(REFRESH_TOKEN, refreshTokenDTO.getRefreshToken());

    return webClient.post()
        .uri(url)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .body(BodyInserters.fromFormData(formData))
        .retrieve()
        .bodyToMono(Void.class)
        .block();

  }

  public AccessTokenResponse refreshToken(RefreshTokenDTO refreshTokenDTO) {

    String url = StringTemplate.template("${authUrl}/realms/${realm}/protocol/openid-connect/token")
        .addParameter(AUTH_URL, keycloakProperties.getAuthServerUrl())
        .addParameter(REALM_STRING, keycloakProperties.getRealm())
        .build();
    MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
    formData.add(CLIENT_ID, keycloakProperties.getResource());
    formData.add(CLIENT_SECRET, keycloakProperties.getSecret());
    formData.add(GRANT_TYPE, REFRESH_TOKEN);
    formData.add(REFRESH_TOKEN, refreshTokenDTO.getRefreshToken());

    return webClient.post()
        .uri(url)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .body(BodyInserters.fromFormData(formData))
        .retrieve()
        .bodyToMono(AccessTokenResponse.class)
        .block();

  }

}
