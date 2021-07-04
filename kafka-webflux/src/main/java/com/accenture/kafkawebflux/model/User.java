package com.accenture.kafkawebflux.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("public.user")
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String name;
    private boolean flag = false;
    private int score;
    @Column("odd_score")
    private boolean oddScore;

    public User(UserDTO dto) {
        this.name = dto.getName();
        this.score = dto.getScore();
        this.oddScore = dto.getScore() % 2 != 0;
    }
}
