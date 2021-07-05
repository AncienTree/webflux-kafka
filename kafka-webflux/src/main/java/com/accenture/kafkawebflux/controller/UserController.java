package com.accenture.kafkawebflux.controller;

import com.accenture.kafkawebflux.model.User;
import com.accenture.kafkawebflux.model.UserDTO;
import com.accenture.kafkawebflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public Publisher<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/name/{name}")
    public Publisher<User> getByName(@PathVariable String name) {
        return userService.getByName(name);
    }

    @GetMapping("/{id}")
    public Publisher<User> getById(@PathVariable long id) {
        return userService.getById(id);
    }

    @PostMapping("/")
    public Publisher<User> create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }
}
