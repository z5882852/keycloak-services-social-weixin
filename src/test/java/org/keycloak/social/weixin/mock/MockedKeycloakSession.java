package org.keycloak.social.weixin.mock;

import jakarta.ws.rs.core.HttpHeaders;
import org.keycloak.common.ClientConnection;
import org.keycloak.component.ComponentModel;
import org.keycloak.http.HttpRequest;
import org.keycloak.http.HttpResponse;
import org.keycloak.models.*;
import org.keycloak.provider.InvalidationHandler;
import org.keycloak.provider.Provider;
import org.keycloak.services.clientpolicy.ClientPolicyManager;
import org.keycloak.sessions.AuthenticationSessionModel;
import org.keycloak.sessions.AuthenticationSessionProvider;
import org.keycloak.urls.UrlType;
import org.keycloak.vault.VaultTranscriber;
import org.keycloak.Token;

import java.net.URI;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class MockedKeycloakSession implements KeycloakSession {
    private final HttpRequest httpRequest;

    public MockedKeycloakSession(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public IdentityProviderStorageProvider identityProviders() {
        return null;
    }

    @Override
    public KeycloakContext getContext() {
        return new KeycloakContext() {
            @Override
            public URI getAuthServerUrl() {
                return null;
            }

            @Override
            public String getContextPath() {
                return null;
            }

            @Override
            public KeycloakUriInfo getUri() {
                return null;
            }

            @Override
            public KeycloakUriInfo getUri(UrlType urlType) {
                return null;
            }

            @Override
            public HttpHeaders getRequestHeaders() {
                return httpRequest.getHttpHeaders();
            }

            @Override
            public RealmModel getRealm() {
                return null;
            }

            @Override
            public void setRealm(RealmModel realmModel) {
            }

            @Override
            public ClientModel getClient() {
                return null;
            }

            @Override
            public void setClient(ClientModel clientModel) {
            }

            @Override
            public ClientConnection getConnection() {
                return null;
            }

            @Override
            public void setConnection(ClientConnection connection) {
            }

            @Override
            public Locale resolveLocale(UserModel userModel) {
                return null;
            }

            @Override
            public AuthenticationSessionModel getAuthenticationSession() {
                return null;
            }

            @Override
            public void setAuthenticationSession(AuthenticationSessionModel authenticationSessionModel) {
            }

            @Override
            public HttpRequest getHttpRequest() {
                return null;
            }

            @Override
            public void setHttpRequest(HttpRequest request) {
            }

            @Override
            public HttpResponse getHttpResponse() {
                return null;
            }

            @Override
            public void setHttpResponse(HttpResponse response) {
            }

            @Override
            public UserSessionModel getUserSession() {
                return null;
            }

            @Override
            public void setUserSession(UserSessionModel userSession) {
            }

            @Override
            public Token getBearerToken() {
                return null;
            }

            @Override
            public void setBearerToken(Token token) {
            }

            @Override
            public OrganizationModel getOrganization() {
                return null;
            }

            @Override
            public void setOrganization(OrganizationModel organization) {
            }
        };
    }

    @Override
    public KeycloakTransactionManager getTransactionManager() {
        return null;
    }

    @Override
    public <T extends Provider> T getProvider(Class<T> aClass) {
        return null;
    }

    @Override
    public <T extends Provider> T getProvider(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public <T extends Provider> T getComponentProvider(Class<T> aClass, String s) {
        return null;
    }

    @Override
    public <T extends Provider> T getComponentProvider(Class<T> aClass, String s, Function<KeycloakSessionFactory, ComponentModel> function) {
        return null;
    }

    @Override
    public <T extends Provider> T getProvider(Class<T> aClass, ComponentModel componentModel) {
        return null;
    }

    @Override
    public <T extends Provider> Set<String> listProviderIds(Class<T> aClass) {
        return null;
    }

    @Override
    public <T extends Provider> Set<T> getAllProviders(Class<T> aClass) {
        return null;
    }

    @Override
    public Class<? extends Provider> getProviderClass(String s) {
        return null;
    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public <T> T getAttribute(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public Object removeAttribute(String s) {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    @Override
    public void invalidate(InvalidationHandler.InvalidableObjectType invalidableObjectType, Object... objects) {

    }

    @Override
    public void enlistForClose(Provider provider) {

    }

    @Override
    public KeycloakSessionFactory getKeycloakSessionFactory() {
        return null;
    }

    @Override
    public RealmProvider realms() {
        return null;
    }

    @Override
    public ClientProvider clients() {
        return null;
    }

    @Override
    public ClientScopeProvider clientScopes() {
        return null;
    }

    @Override
    public GroupProvider groups() {
        return null;
    }

    @Override
    public RoleProvider roles() {
        return null;
    }

    @Override
    public UserSessionProvider sessions() {
        return null;
    }

    @Override
    public UserLoginFailureProvider loginFailures() {
        return null;
    }

    @Override
    public AuthenticationSessionProvider authenticationSessions() {
        return null;
    }

    @Override
    public SingleUseObjectProvider singleUseObjects() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public UserProvider users() {
        return null;
    }

    @Override
    public KeyManager keys() {
        return null;
    }

    @Override
    public ThemeManager theme() {
        return null;
    }

    @Override
    public TokenManager tokens() {
        return null;
    }

    @Override
    public VaultTranscriber vault() {
        return null;
    }

    @Override
    public ClientPolicyManager clientPolicy() {
        return null;
    }
}
