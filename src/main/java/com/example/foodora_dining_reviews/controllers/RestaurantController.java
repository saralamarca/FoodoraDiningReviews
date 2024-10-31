package com.example.foodora_dining_reviews.controllers;

import com.example.foodora_dining_reviews.models.Restaurant;
import com.example.foodora_dining_reviews.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The RestaurantController class handles incoming HTTP requests related to Restaurant entities.
 * It provides endpoints for creating, reading, updating, and deleting restaurants.
 */
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    // Injecting the RestaurantService to handle business logic
    @Autowired
    private RestaurantService service;

    /**
     * Retrieves all restaurants.
     * @return an Iterable of all Restaurant entities.
     */
    @GetMapping
    public Iterable<Restaurant> getRestaurants() {
        return service.readAll();
    }

    /**
     * Retrieves a specific restaurant by its ID.
     * @param id the ID of the restaurant to retrieve.
     * @return a ResponseEntity containing the Restaurant entity if found, or a 404 Not Found status if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable String id) {
        Restaurant restaurant = service.readOne(id);
        return restaurant != null ? new ResponseEntity<>(restaurant, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Creates a new restaurant.
     * @param restaurant the Restaurant entity to create, provided in the request body.
     * @return a ResponseEntity with a 201 Created status and a confirmation message.
     */
    @PostMapping
    public ResponseEntity<String> createRestaurant(@RequestBody Restaurant restaurant) {
        service.createRestaurant(restaurant);
        return new ResponseEntity<>("Restaurant created", HttpStatus.CREATED);
    }

    /**
     * Updates an existing restaurant by its ID.
     * @param id the ID of the restaurant to update.
     * @param restaurant the updated Restaurant entity data, provided in the request body.
     * @return a ResponseEntity with a 200 OK status and a confirmation message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant) {
        service.updateRestaurant(id, restaurant);
        return new ResponseEntity<>("Restaurant updated", HttpStatus.OK);
    }

    /**
     * Deletes a restaurant by its ID.
     * @param id the ID of the restaurant to delete.
     * @return a ResponseEntity with a 200 OK status and a confirmation message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable String id) {
        service.deleteRestaurant(id);
        return new ResponseEntity<>("Restaurant deleted", HttpStatus.OK);
    }
}
