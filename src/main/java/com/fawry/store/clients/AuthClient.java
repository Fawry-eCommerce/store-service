package com.fawry.store.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "admin-service", path = "/admin-api/auth")
public interface AuthClient {
    @PostMapping("validate")
    boolean validateToken(@RequestParam String token);
    @GetMapping("has-role")
    boolean hasRole(@RequestParam String role, @RequestParam String token);
    @GetMapping("has-any-role")
    boolean hasAnyRole(@RequestHeader("Authorization") String token, @RequestParam String... roles);
}
