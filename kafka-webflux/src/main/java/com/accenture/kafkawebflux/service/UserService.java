package com.accenture.kafkawebflux.service;

import com.accenture.kafkawebflux.repository.UserRepository;
import com.accenture.kafkawebflux.model.User;
import com.accenture.kafkawebflux.model.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @KafkaListener(topics = "test-topic2")
    public void consume(UserDTO userDTO) {
        log.info(String.format("Consume DTO: %s", userDTO.toString()));
        userRepository.save(new User(userDTO)).subscribe();
    }

    public Mono<User> create(UserDTO userDTO) {
        log.info(String.format("Consume rest DTO: %s", userDTO.toString()));
        return userRepository.save(new User(userDTO));
    }

    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    public Flux<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public Mono<User> getById(long id) {
        return userRepository.findById(id);
    }
}
