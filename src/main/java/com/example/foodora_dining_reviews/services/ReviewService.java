package com.example.foodora_dining_reviews.services;

import com.example.foodora_dining_reviews.models.Review;
import com.example.foodora_dining_reviews.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Service class for handling business logic related to Review entities.
 * Provides methods for creating, reading, updating, and deleting reviews.
 */
@Service
public class ReviewService {

    // Repository for performing CRUD operations on Review entities
    private final ReviewRepository repository;

    // Constructor injection for ReviewRepository
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new review by setting the current date and time, then saving it to the repository.
     * @param review the Review entity to be created.
     */
    public void createReview(Review review) {
        review.setReviewDate(LocalDateTime.now());
        repository.save(review);
    }

    /**
     * Retrieves all reviews.
     * @return an Iterable containing all Review entities.
     */
    public Iterable<Review> readAll() {
        return repository.findAll();
    }

    /**
     * Retrieves a specific review by its ID.
     * @param id the ID of the review to retrieve.
     * @return the Review entity if found, or null if not found.
     */
    public Review readOne(String id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Updates an existing review with new details.
     * If the review with the given ID exists, its fields are updated
     * with values from the updatedReview object, and the review date is set to the current date and time.
     * @param id the ID of the review to update.
     * @param updatedReview the Review entity containing updated values.
     */
    public void updateReview(String id, Review updatedReview) {
        Optional<Review> existingReview = repository.findById(id);

        if (existingReview.isPresent()) {
            Review review = existingReview.get();
            review.setRating(updatedReview.getRating());
            review.setComment(updatedReview.getComment());
            review.setReviewDate(LocalDateTime.now());
            repository.save(review);
        }
    }

    /**
     * Deletes a review by its ID.
     * @param id the ID of the review to delete.
     */
    public void deleteReview(String id) {
        repository.deleteById(id);
    }
}
