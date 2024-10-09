package com.umaxcode.Keycloak.Integration.With.Spring.Boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Maxwell Odoom",
                        email = "maxwelloddoom1729@gmail.com",
                        url = "umaxcode.com"
                ),
                title = "Spring boot with keycloak",
                description = "Using keycloak as an authentication/authorization server and spring boot application" +
                        "as the resource server",
                version = "1.0",
                license = @License(
                        name = "Maxwell License",
                        url = "license.max.come"
                ),
                termsOfService = "My Term Of Service"

        )
        ,
        servers = {
                @Server(
                        url = "http://localhost:8082/api/v1",
                        description = "Server For Dev"
                )
                ,
                @Server(
                        url = "http:prod",
                        description = "Server For Prod"
                )
        }
        ,
        security = {
                @SecurityRequirement(
                        name = "umaxcode"
                )
        }
)
@SecurityScheme(
        name = "keycloak",
        description = "Umaxcode security scheme",
        openIdConnectUrl = "http://localhost:8080/realms/umaxcode/.well-known/openid-configuration",
        type = SecuritySchemeType.OPENIDCONNECT,
        bearerFormat = "JWT",
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
