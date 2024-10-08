package com.umaxcode.Keycloak.Integration.With.Spring.Boot.exception;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

    private String path;

    private String message;

    private LocalDateTime timestamp;
}
