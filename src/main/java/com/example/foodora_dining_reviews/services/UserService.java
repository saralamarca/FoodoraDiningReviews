package com.example.foodora_dining_reviews.services;

import com.example.foodora_dining_reviews.models.User;
import com.example.foodora_dining_reviews.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling business logic related to User entities.
 * Provides methods for creating, reading, updating, and deleting users.
 */
@Service
public class UserService {

    // Repository for performing CRUD operations on User entities
    private final UserRepository repository;

    // Constructor injection for UserRepository
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new user by saving it to the repository.
     * @param user the User entity to be created.
     */
    public void createUser(User user) {
        repository.save(user);
    }

    /**
     * Retrieves all users.
     * @return an Iterable containing all User entities.
     */
    public Iterable<User> readAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a specific user by their ID.
     * @param id the ID of the user to retrieve.
     * @return the User entity if found, or null if not found.
     */
    public User readOne(String id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Updates an existing user with new details.
     * If the user with the given ID exists, their fields are updated with values from the updatedUser object.
     * @param id the ID of the user to update.
     * @param updatedUser the User entity containing updated values.
     */
    public void updateUser(String id, User updatedUser) {
        Optional<User> existingUser = repository.findById(id);

        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            repository.save(user);
        }
    }

    /**
     * Deletes a user by their ID.
     * @param id the ID of the user to delete.
     */
    public void deleteUser(String id) {
        repository.deleteById(id);
    }
}
