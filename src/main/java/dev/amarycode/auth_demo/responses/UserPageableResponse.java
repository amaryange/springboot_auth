package dev.amarycode.auth_demo.responses;

import dev.amarycode.auth_demo.entities.Users;
import dev.amarycode.auth_demo.enums.Role;
import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UserPageableResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;


    public static UserPageableResponse fromEntity(Users user) {
        return UserPageableResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

}
