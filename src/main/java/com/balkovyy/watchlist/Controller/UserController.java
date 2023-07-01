package com.balkovyy.watchlist.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balkovyy.watchlist.Entities.User;
import com.balkovyy.watchlist.Repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
    public UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/by-role")
    public List<User> getUsersByRole(@RequestParam("role") String role) {
        return userRepository.findByRole(role);
    }

    @GetMapping("/search/email")
    public ResponseEntity<User> searchUserByEmail(@RequestParam("email") String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/username")
    public ResponseEntity<User> searchUserByUsername(@RequestParam("username") String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
