package dev.amarycode.auth_demo.services;

import dev.amarycode.auth_demo.entities.Users;
import dev.amarycode.auth_demo.repositories.UsersRepository;
import dev.amarycode.auth_demo.responses.UserPageableResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UsersRepository userRepository;

    public Page<UserPageableResponse> searchUsers(String searchTerm, int page, int size, String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Users> usersPage = searchTerm == null || searchTerm.isEmpty()
                ? userRepository.findAll(pageable)
                : userRepository.searchUsers(searchTerm.toLowerCase(), pageable);

        return usersPage.map(UserPageableResponse::fromEntity);
    }
}
