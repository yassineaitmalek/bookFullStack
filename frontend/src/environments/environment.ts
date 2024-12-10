import { KeycloakOptions } from 'keycloak-angular';

// Add here your keycloak setup infos
const keycloakConfig: KeycloakOptions = {
  config: {
    url: 'http://localhost:9998/auth',
    realm: 'portail-digital',
    clientId: 'portail-digital',
  },
  initOptions: {
    onLoad: 'login-required',
    checkLoginIframe: false,
  },
  enableBearerInterceptor: true,
  bearerExcludedUrls: ['/assets', '/clients/public'],
};

export const environment = {
  production: false,
  keycloak: keycloakConfig,
  SERVER_API_URL: 'http://localhost:8080',
};
