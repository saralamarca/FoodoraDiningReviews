package com.example.foodora_dining_reviews.controllers;

import com.example.foodora_dining_reviews.models.Review;
import com.example.foodora_dining_reviews.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The ReviewController class handles HTTP requests related to Review entities.
 * It provides endpoints for creating, reading, updating, and deleting reviews.
 */
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    // Injecting the ReviewService to handle business logic
    @Autowired
    private ReviewService service;

    /**
     * Retrieves all reviews.
     * @return an Iterable of all Review entities.
     */
    @GetMapping
    public Iterable<Review> getReviews() {
        return service.readAll();
    }

    /**
     * Retrieves a specific review by its ID.
     * @param id the ID of the review to retrieve.
     * @return a ResponseEntity containing the Review entity if found, or a 404 Not Found status if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable String id) {
        Review review = service.readOne(id);
        return review != null ? new ResponseEntity<>(review, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Creates a new review.
     * @param review the Review entity to create, provided in the request body.
     * @return a ResponseEntity with a 201 Created status and a confirmation message.
     */
    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        service.createReview(review);
        return new ResponseEntity<>("Review created", HttpStatus.CREATED);
    }

    /**
     * Updates an existing review by its ID.
     * @param id the ID of the review to update.
     * @param review the updated Review entity data, provided in the request body.
     * @return a ResponseEntity with a 200 OK status and a confirmation message.
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateReview(@PathVariable String id, @RequestBody Review review) {
        service.updateReview(id, review);
        return new ResponseEntity<>("Review updated", HttpStatus.OK);
    }

    /**
     * Deletes a review by its ID.
     * @param id the ID of the review to delete.
     * @return a ResponseEntity with a 200 OK status and a confirmation message.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable String id) {
        service.deleteReview(id);
        return new ResponseEntity<>("Review deleted", HttpStatus.OK);
    }
}
