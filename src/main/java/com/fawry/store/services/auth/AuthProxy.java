package com.fawry.store.services.auth;

import com.fawry.store.clients.AuthClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthProxy {

    private AuthClient authClient;

    public boolean validateToken(String token) {
        return authClient.validateToken(token);
    }

    public boolean hasRole(String role, String token) {
        return authClient.hasRole(role, token);
    }

    public boolean hasAnyRole(String token, String... roles) {
        return authClient.hasAnyRole(token, roles);
    }

}
