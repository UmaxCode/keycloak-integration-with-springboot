# Keycloak Integration with Spring Boot

This project demonstrates how to integrate **Keycloak** with a **Spring Boot** application. Keycloak acts as the
authentication and authorization server, while the Spring Boot application is the resource server that verifies tokens
using both **Opaque Tokens** and **JWT (JSON Web Tokens)** issued by Keycloak.

## Project Overview

- **Keycloak**: Acts as the Identity Provider (IdP) handling authentication and authorization.
- **Spring Boot**: Acts as the Resource Server that verifies tokens from Keycloak.
    - The Spring Boot application supports both **opaque tokens** and **JWT** for authentication.

## Key Features

- **Authentication & Authorization**: Using Keycloak as the IdP.
- **Token Verification**: Supports both **Opaque Tokens** (via introspection) and **JWT Tokens** (via decoding).
- **Secured API Endpoints**: APIs in Spring Boot are secured using Spring Security with Keycloak integration.

