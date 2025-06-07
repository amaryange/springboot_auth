package dev.amarycode.auth_demo.repositories;

import dev.amarycode.auth_demo.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    @Query("SELECT u FROM Users u WHERE " +
            "LOWER(u.email) ILIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.firstname) ILIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(u.lastname) ILIKE LOWER(CONCAT('%', :searchTerm, '%'))")
    Page<Users> searchUsers(@Param("searchTerm") String searchTerm, Pageable pageable);

}
