package com.example.BlogPlat.User;

import com.example.BlogPlat.Message;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/signup")
    public Message signup(@RequestBody User user) {
        if (userService.signup(user)) {
            return new Message("User created successfully");
        } else {
            return new Message("Failed to create user");
        }
    }


}
