package com.iswar.usercrud.controller;

import com.iswar.usercrud.entity.User;
import com.iswar.usercrud.error.ResourceNotFound;
import com.iswar.usercrud.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get all users
    @GetMapping
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    // get user by {id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            throw new ResourceNotFound("User not found with ID: " + id);
        }
    }

    // create a new user
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    // update a user by {id}
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable("id") Integer id, @RequestBody User user) throws Exception{
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {

            User existingUser = existingUserOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());

            User updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            throw new Exception("User not found with ID: " + id);
        }
    }

    // delete a user by {id}
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        } else {
            throw new Exception("Not find the User with ID: " + id + " for Delete.");
        }
    }
}
