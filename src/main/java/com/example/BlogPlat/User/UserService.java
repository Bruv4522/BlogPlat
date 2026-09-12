package com.example.BlogPlat.User;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

@AllArgsConstructor
public class UserService {
    private UserRepo repo;

    public boolean signup(User user) {
        try {
            repo.save(new User(user.getUsername(), BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
