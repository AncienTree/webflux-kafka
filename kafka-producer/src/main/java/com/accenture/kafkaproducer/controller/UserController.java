package com.accenture.kafkaproducer.controller;

import com.accenture.kafkaproducer.dto.UserDTO;
import com.accenture.kafkaproducer.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/publish")
    public void sendMessageToKafka(@RequestParam("name") String name,
                                   @RequestParam("score") int score) {
        var userDTO = new UserDTO(name, score);
        this.userService.sendMessage(userDTO);
    }

    @PostMapping("/massSend")
    public void sendMassToKafka (@RequestParam("name") String name,
                                @RequestParam("score") int score,
                                @RequestParam("quantity") int quantity) {

        var random = new Random(100000);
        for (var i = 0; i < quantity; i++) {
            var userDTO = new UserDTO(name + " " + random.nextInt(), score);
            this.userService.sendMessage(userDTO);
        }
    }

    @PostMapping("/massApi")
    public void sendMassToApi (@RequestParam("name") String name,
                                 @RequestParam("score") int score,
                                 @RequestParam("quantity") int quantity) {
        var restTemplate = new RestTemplate();
        var random = new Random(100000);
        for (var i = 0; i < quantity; i++) {
            var userDTO = new UserDTO(name + " " + random.nextInt(), score);
            restTemplate.postForObject("http://localhost:8080/api/user/", userDTO, UserDTO.class);
            this.userService.sendMessage(userDTO);
        }
    }
}
