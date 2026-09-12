package com.example.BlogPlat.User;

import com.example.BlogPlat.LoginRes;
import com.example.BlogPlat.Message;
import com.example.BlogPlat.Token.TokenRepo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class UserController {
    private UserService service;
    private TokenRepo tokenRepo;

    @PostMapping("/signup")
    public Message signup(@RequestBody User user) {
        if (service.signup(user)) {
            return new Message("User created successfully");
        } else {
            return new Message("Failed to create user");
        }
    }

    @PostMapping("/login")
    public LoginRes login(@RequestBody User user) {
        if (service.login(user)) {
            return new LoginRes("Login successful", tokenRepo.findByUserUsername(user.getUsername()).getId());
        } else {
            return new LoginRes("Invalid credentials", null);
        }
    }
}
