package com.example.BlogPlat.User;

import com.example.BlogPlat.Token.Token;
import com.example.BlogPlat.Token.TokenRepo;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo repo;
    private TokenRepo token;

    public boolean signup(User user) {
        try {
            repo.save(new User(user.getUsername(), BCrypt.hashpw(user.getPassword(), BCrypt.gensalt())));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean login(User user) {
        if (!repo.existsByUsername(user.getUsername())) {
            return false;
        }

        User foundUser = repo.findByUsername(user.getUsername());

        if (BCrypt.checkpw(user.getPassword(), foundUser.getPassword())) {
            if (!token.existsByUser(foundUser)) {
                token.save(new Token(foundUser));
            }

            return true;
        }

        return false;
    }
}
