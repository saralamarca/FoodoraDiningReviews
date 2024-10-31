package com.example.foodora_dining_reviews.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

/**
 * The Restaurant class represents a restaurant entity with basic details
 * such as name, address, and cuisine type.
 */
@Entity
public class Restaurant {

    // Unique identifier for each restaurant, automatically generated as a UUID
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Name of the restaurant; cannot be null
    @Column(nullable = false)
    private String name;

    // Address of the restaurant; can be null
    private String address;

    // Type of cuisine served by the restaurant; can be null
    private String cuisine;

    // Getters and Setters

    /**
     * Gets the unique identifier of the restaurant.
     * @return the restaurant's unique ID as a String.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the restaurant.
     * @return the name of the restaurant.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the restaurant.
     * @param name the name to set for the restaurant.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the address of the restaurant.
     * @return the address of the restaurant.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address of the restaurant.
     * @param address the address to set for the restaurant.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets the type of cuisine served by the restaurant.
     * @return the cuisine type as a String.
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * Sets the type of cuisine served by the restaurant.
     * @param cuisine the type of cuisine to set.
     */
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }
}
