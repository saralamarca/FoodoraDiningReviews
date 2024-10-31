package com.example.foodora_dining_reviews.repositories;

import com.example.foodora_dining_reviews.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for Restaurant entity, providing basic CRUD operations.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
