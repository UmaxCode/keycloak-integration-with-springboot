package com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.request;

import lombok.Builder;

@Builder
public record PostRequestDTO(
        String title,
        String content
) {
}
