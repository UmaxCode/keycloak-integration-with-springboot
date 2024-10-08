package com.umaxcode.Keycloak.Integration.With.Spring.Boot.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponse {

    private String message;
    private Object data;
}
