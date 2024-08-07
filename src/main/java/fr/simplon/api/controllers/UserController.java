package fr.simplon.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.models.User;
import fr.simplon.api.repositories.UserRepository;

// @Controller retourne du html, ce sera le nom d'une vue à aller chercher, ce ne sera pas renvoyé au client
// @RestController Permet de renvoyer du json au client ?
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public Optional<User> getAllUsers(@PathVariable Integer userId) {
        return userRepository.findById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User newUser = new User(user.getUsername());
        return userRepository.save(newUser);
    }

}
