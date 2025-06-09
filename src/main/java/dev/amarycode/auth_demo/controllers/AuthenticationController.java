package dev.amarycode.auth_demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import dev.amarycode.auth_demo.requests.AuthenticationRequest;
import dev.amarycode.auth_demo.requests.RegisterRequest;
import dev.amarycode.auth_demo.responses.AuthenticationResponse;
import dev.amarycode.auth_demo.responses.UserResponse;
import dev.amarycode.auth_demo.services.AuthenticationService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.enregistrer(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping
    public ResponseEntity<Map<String, String>> get() {
        Map<String, String> map = new HashMap<>();
        map.put("message", "Hello from public endpoint");
        return ResponseEntity.ok(map);
    }


}
