package com.umaxcode.Keycloak.Integration.With.Spring.Boot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @PreAuthorize("hasRole('client_user')")
    @GetMapping
    public String hello() {

        return "Hello from Spring boot & Keycloak";
    }

    @PreAuthorize("hasRole('client_admin')")
    @GetMapping("/hello-2")
    public String hello2() {

        return "Hello from Spring boot & Keycloak - ADMIN";
    }
}
