package com.example.BlogPlat.Token;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.UUID;

public interface TokenRepo extends JpaRepository<Token, UUID> {
    void deleteAllByExpiresAtBefore(Instant now);
}
