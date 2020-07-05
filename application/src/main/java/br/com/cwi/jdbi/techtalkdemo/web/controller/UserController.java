package br.com.cwi.jdbi.techtalkdemo.web.controller;

import br.com.cwi.jdbi.techtalkdemo.domain.User;
import br.com.cwi.jdbi.techtalkdemo.repository.UserRepository;
import br.com.cwi.jdbi.techtalkdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return this.userService.findUserById(id);
    }
}
