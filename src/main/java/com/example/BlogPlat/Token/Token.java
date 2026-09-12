package com.example.BlogPlat.Token;

import com.example.BlogPlat.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne(mappedBy = "user_id")
    private User user;
    private Instant created = Instant.now();
    private Instant expires = created.plus(7, ChronoUnit.DAYS);
}
