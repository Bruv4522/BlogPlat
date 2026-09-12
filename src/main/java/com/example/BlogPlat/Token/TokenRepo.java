package com.example.BlogPlat.Token;

import com.example.BlogPlat.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;

@Repository
public interface TokenRepo extends JpaRepository<Token, UUID> {
    void deleteAllByExpiresBefore(Instant now);
    boolean existsByUser(User user);
    Token findByUser(User user);
    Token findByUserUsername(String username);
}
