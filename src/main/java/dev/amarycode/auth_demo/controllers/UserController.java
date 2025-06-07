package dev.amarycode.auth_demo.controllers;

import dev.amarycode.auth_demo.entities.Users;
import dev.amarycode.auth_demo.requests.UserPageableRequest;
import dev.amarycode.auth_demo.responses.UserPageableResponse;
import dev.amarycode.auth_demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserPageableRequest<UserPageableResponse>> getUsers(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "lastname") String sortBy,
            @RequestParam(defaultValue = "ASC") String direction) {

        Page<UserPageableResponse> result = userService.searchUsers(search, page, size, sortBy, direction);

        UserPageableRequest<UserPageableResponse> response = new UserPageableRequest<>(
                result.getContent(),
                result.getNumber(),
                result.getTotalPages(),
                result.getTotalElements()
        );

        return ResponseEntity.ok(response);
    }
}
