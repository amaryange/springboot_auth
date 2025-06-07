package dev.amarycode.auth_demo.controllers;

import dev.amarycode.auth_demo.entities.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ConnectedController {

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        if (authentication.getPrincipal() instanceof Users) {
            Users user = (Users) authentication.getPrincipal();

            Map<String, Object> response = new HashMap<>();
            response.put("id", user.getId());
            response.put("email", user.getEmail());
            response.put("firstname", user.getFirstname());
            response.put("lastname", user.getLastname());
            response.put("role", user.getRole());

            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }

}
