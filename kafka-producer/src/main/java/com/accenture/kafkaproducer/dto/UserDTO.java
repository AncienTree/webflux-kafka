package com.accenture.kafkaproducer.dto;

import org.springframework.core.serializer.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

public class UserDTO {
    private String name;
    private int score;

    public UserDTO() {
    }

    public UserDTO(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
