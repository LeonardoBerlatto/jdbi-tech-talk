package br.com.cwi.jdbi.techtalkdemo.service;

import br.com.cwi.jdbi.techtalkdemo.domain.User;
import br.com.cwi.jdbi.techtalkdemo.exception.BadRequestException;
import br.com.cwi.jdbi.techtalkdemo.exception.UserNotFoundException;
import br.com.cwi.jdbi.techtalkdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User createUser(User user) {
        if (this.repository.existsByName(user.getName())) {
            throw new BadRequestException("A user with this name already exists.");
        }

        Long id = repository.createUser(user);

        user.setId(id);
        return user;
    }

    public User findUserById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found."));
    }
}
