package com.example.foodora_dining_reviews.repositories;

import com.example.foodora_dining_reviews.models.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for Review entity, providing basic CRUD operations.
 */
public interface ReviewRepository extends CrudRepository<Review, String> {
}
