package dev.amarycode.auth_demo;

import dev.amarycode.auth_demo.entities.Users;
import dev.amarycode.auth_demo.enums.Role;
import dev.amarycode.auth_demo.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class AuthDemoApplication {

    private final UsersRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(AuthDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        createUsers();
        return (args) -> {
            System.out.println("Users created with success");
        };
    }

    private void createUsers() {
        List<Users> users = List.of(
                // Admin
                Users.builder()
                        .firstname("Admin")
                        .lastname("User")
                        .email("admin@example.com")
                        .password(passwordEncoder.encode("admin123"))
                        .role(Role.ADMIN)
                        .build(),

                // 9 autres utilisateurs
                Users.builder()
                        .firstname("John")
                        .lastname("Doe")
                        .email("john.doe@example.com")
                        .password(passwordEncoder.encode("password1"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("Jane")
                        .lastname("Smith")
                        .email("jane.smith@example.com")
                        .password(passwordEncoder.encode("password2"))
                        .role(Role.USER)
                        .build(),

                // Ajoutez 7 autres utilisateurs de la même manière
                Users.builder()
                        .firstname("Alice")
                        .lastname("Johnson")
                        .email("alice.johnson@example.com")
                        .password(passwordEncoder.encode("password3"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("Bob")
                        .lastname("Williams")
                        .email("bob.williams@example.com")
                        .password(passwordEncoder.encode("password4"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("Charlie")
                        .lastname("Brown")
                        .email("charlie.brown@example.com")
                        .password(passwordEncoder.encode("password5"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("David")
                        .lastname("Miller")
                        .email("david.miller@example.com")
                        .password(passwordEncoder.encode("password6"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("Eve")
                        .lastname("Davis")
                        .email("eve.davis@example.com")
                        .password(passwordEncoder.encode("password7"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("Frank")
                        .lastname("Wilson")
                        .email("frank.wilson@example.com")
                        .password(passwordEncoder.encode("password8"))
                        .role(Role.USER)
                        .build(),

                Users.builder()
                        .firstname("Grace")
                        .lastname("Taylor")
                        .email("grace.taylor@example.com")
                        .password(passwordEncoder.encode("password9"))
                        .role(Role.USER)
                        .build()
        );

        userRepository.saveAll(users);
    }

}
