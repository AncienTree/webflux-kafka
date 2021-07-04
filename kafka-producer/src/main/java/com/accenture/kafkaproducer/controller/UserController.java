package com.accenture.kafkaproducer.controller;

import com.accenture.kafkaproducer.dto.UserDTO;
import com.accenture.kafkaproducer.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/publish")
    public void sendMessageToKafka(@RequestParam("name") String name,
                                   @RequestParam("score") int score) {
        UserDTO userDTO = new UserDTO(name, score);
        this.userService.sendMessage(userDTO);
    }
}
