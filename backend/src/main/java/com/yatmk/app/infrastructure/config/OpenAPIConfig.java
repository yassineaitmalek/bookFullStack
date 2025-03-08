package com.yatmk.app.infrastructure.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "APP - BOOKS", version = "1.0", description = "APP - BOOKS"))
public class OpenAPIConfig {

  private static final String SECURITY_SCHEME_NAME = "bearerAuth";

  private static final String SECURITY_SCHEME = "bearer";

  private static final String SECURITY_BEARER_FORMAT = "bearer";

  @Value("${server.servlet.context-path:/}")
  private final String path;

  @Bean
  public OpenAPI getOpenAPI() {

    return new OpenAPI()
        .servers(getServers())
        .addSecurityItem(getSecurityRequirement())
        .components(getComponents())

    ;

  }

  public List<Server> getServers() {

    Server server = new Server();
    server.setUrl(path);
    return Arrays.asList(server);

  }

  private SecurityRequirement getSecurityRequirement() {
    return new SecurityRequirement()
        .addList(SECURITY_SCHEME_NAME);

  }

  private Components getComponents() {
    return new Components()
        .addSecuritySchemes(SECURITY_SCHEME_NAME, getSecurityScheme());

  }

  private SecurityScheme getSecurityScheme() {

    return new SecurityScheme()
        .name(SECURITY_SCHEME_NAME)
        .type(SecurityScheme.Type.HTTP)
        .scheme(SECURITY_SCHEME)
        .bearerFormat(SECURITY_BEARER_FORMAT);

  }

}
