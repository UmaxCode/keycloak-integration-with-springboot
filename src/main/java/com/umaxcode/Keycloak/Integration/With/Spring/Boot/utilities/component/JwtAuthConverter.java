package com.umaxcode.Keycloak.Integration.With.Spring.Boot.utilities.component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtAuthConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Value("${application.keycloak.client-id}")
    String clientId;

    @Override
    public AbstractAuthenticationToken convert(@NonNull Jwt jwt) {

        Collection<SimpleGrantedAuthority> roles = extractRoles(jwt);
        return new JwtAuthenticationToken(jwt, roles, getPrincipleClaimName(jwt));
    }

    private String getPrincipleClaimName(Jwt jwt) {

        return jwt.getClaim("preferred_username");
    }

    private Collection<SimpleGrantedAuthority> extractRoles(Jwt jwt) {

        if (jwt.getClaim("resource_access") != null) {
            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");

            if (resourceAccess.get(clientId) != null) {

                Map<String, Object> applicationAccess = (Map<String, Object>) resourceAccess.get(clientId);

                ObjectMapper objectMapper = new ObjectMapper();
                List<String> keycloakRoles = objectMapper.convertValue(applicationAccess.get("roles"), new TypeReference<>() {
                });

                Set<SimpleGrantedAuthority> roles = new HashSet<>();

                for (String keycloakRole : keycloakRoles) {
                    roles.add(new SimpleGrantedAuthority(keycloakRole));
                }
                return roles;
            }

        }

        return Set.of();
    }
}
