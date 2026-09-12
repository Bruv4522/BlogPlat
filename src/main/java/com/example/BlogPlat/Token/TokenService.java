package com.example.BlogPlat.Token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {
    private final TokenRepo repo;
}
