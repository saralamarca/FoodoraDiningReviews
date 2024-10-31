package com.example.foodora_dining_reviews.controllers;

import com.example.foodora_dining_reviews.models.User;
import com.example.foodora_dining_reviews.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The UserController class handles HTTP requests related to User entities.
 * It provides endpoints for creating, reading, updating, and deleting users.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    // Injecting the UserService to handle business logic
    @Autowired
    private UserService service;

    /**
     * Retrieves all users.
     * @return an Iterable of all User entities.
     */
    @GetMapping
    public Iterable<User> getUsers() {
        return service.readAll();
    }

    /**
     * Retrieves a specific user by their ID.
     * @param id the ID of the user to retrieve.
     * @return a ResponseEntity containing the User entity if found, or a 404 Not Found status if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = service.readOne(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates a new user.
     * @param user the User entity to create, provided in the request body.
     * @return a ResponseEntity with a 201 Created status and a confirmation message.
     */
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        service.createUser(user);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }

    /**
     * Updates an existing user by their ID.
     * @param id the ID of the user to update.
     * @param user the updated User entity data, provided in the request body.
     * @return a ResponseEntity with a 200 OK status and a confirmation message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) {
        service.updateUser(id, user);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }

    /**
     * Deletes a user by their ID.
     * @param id the ID of the user to delete.
     * @return a ResponseEntity with a 200 OK status and a confirmation message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        service.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
