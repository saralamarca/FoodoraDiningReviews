package com.example.foodora_dining_reviews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

/**
 * The User class represents a user entity in the system, with details such as username,
 * email, and password for authentication and identification purposes.
 */
@Entity
public class User {

    // Unique identifier for each user, automatically generated as a UUID
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Unique username for the user; cannot be null
    @Column(nullable = false, unique = true)
    private String username;

    // Unique email for the user; cannot be null
    @Column(nullable = false, unique = true)
    private String email;

    // User's password; intended for authentication
    private String password;

    // Getters and Setters

    /**
     * Gets the unique identifier of the user.
     * @return the user's unique ID as a String.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user.
     * Primarily used by the framework to set generated IDs.
     * @param id the unique ID to set.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the username of the user.
     * @return the username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the user.
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the email of the user.
     * @return the user's email as a String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email for the user.
     * @param email the email to set for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     * @return the password as a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user.
     * @param password the password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
