package com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.response;

import lombok.Builder;

@Builder
public record PostResponseDTO(
        String id,
        String title,
        String content
) {
}
