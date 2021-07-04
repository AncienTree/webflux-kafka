package com.accenture.kafkaproducer.service;

import com.accenture.kafkaproducer.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private static final String TOPIC = "test-topic2";

    @Autowired
    private KafkaTemplate<String, UserDTO> kafkaTemplateUser;

    public void sendMessage(UserDTO user)  {
        LOGGER.info(String.format("Sending User: %s to topic: %s .", user.getName(), TOPIC));
        this.kafkaTemplateUser.send(TOPIC, user);
    }
}
