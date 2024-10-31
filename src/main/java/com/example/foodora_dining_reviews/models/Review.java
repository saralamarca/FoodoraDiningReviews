package com.example.foodora_dining_reviews.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * The Review class represents a review entity with details such as the user who
 * submitted it, the restaurant being reviewed, the rating, comments, and the date of the review.
 */
@Entity
public class Review {

    // Unique identifier for each review, automatically generated as a UUID
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // The user who submitted the review; mapped to the User entity
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // The restaurant being reviewed; mapped to the Restaurant entity
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    // Rating given to the restaurant by the user, typically on a scale (e.g., 1-5)
    private int rating;

    // Comment text for the review, limited to 500 characters
    @Column(length = 500)
    private String comment;

    // The date and time when the review was submitted
    private LocalDateTime reviewDate;

    // Getters and Setters

    /**
     * Gets the unique identifier of the review.
     * @return the review's unique ID as a String.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the user who submitted the review.
     * @return the User entity associated with this review.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who submitted the review.
     * @param user the User entity to associate with this review.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the restaurant being reviewed.
     * @return the Restaurant entity associated with this review.
     */
    public Restaurant getRestaurant() {
        return restaurant;
    }

    /**
     * Sets the restaurant being reviewed.
     * @param restaurant the Restaurant entity to associate with this review.
     */
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    /**
     * Gets the rating given to the restaurant.
     * @return the rating as an integer.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating for the restaurant.
     * @param rating the integer value representing the rating.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the comment left by the user for the review.
     * @return the comment text as a String.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment for the review.
     * @param comment the comment text as a String.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the date and time the review was submitted.
     * @return the review date as a LocalDateTime.
     */
    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    /**
     * Sets the date and time the review was submitted.
     * @param reviewDate the date and time as a LocalDateTime.
     */
    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
}
