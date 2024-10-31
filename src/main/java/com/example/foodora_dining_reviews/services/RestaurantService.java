package com.example.foodora_dining_reviews.services;

import com.example.foodora_dining_reviews.models.Restaurant;
import com.example.foodora_dining_reviews.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for handling business logic related to Restaurant entities.
 * Provides methods for creating, reading, updating, and deleting restaurants.
 */
@Service
public class RestaurantService {

    // Repository for performing CRUD operations on Restaurant entities
    private final RestaurantRepository repository;

    // Constructor injection for RestaurantRepository
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new restaurant by saving it to the repository.
     * @param restaurant the Restaurant entity to be created.
     */
    public void createRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    /**
     * Retrieves all restaurants.
     * @return an Iterable containing all Restaurant entities.
     */
    public Iterable<Restaurant> readAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a specific restaurant by its ID.
     * @param id the ID of the restaurant to retrieve.
     * @return the Restaurant entity if found, or null if not found.
     */
    public Restaurant readOne(String id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Updates an existing restaurant with new details.
     * If the restaurant with the given ID exists, its fields are updated
     * with values from the updatedRestaurant object and saved to the repository.
     * @param id the ID of the restaurant to update.
     * @param updatedRestaurant the Restaurant entity containing updated values.
     */
    public void updateRestaurant(String id, Restaurant updatedRestaurant) {
        Optional<Restaurant> existingRestaurant = repository.findById(id);

        if (existingRestaurant.isPresent()) {
            Restaurant restaurant = existingRestaurant.get();
            restaurant.setName(updatedRestaurant.getName());
            restaurant.setAddress(updatedRestaurant.getAddress());
            restaurant.setCuisine(updatedRestaurant.getCuisine());
            repository.save(restaurant);
        }
    }

    /**
     * Deletes a restaurant by its ID.
     * @param id the ID of the restaurant to delete.
     */
    public void deleteRestaurant(String id) {
        repository.deleteById(id);
    }
}
