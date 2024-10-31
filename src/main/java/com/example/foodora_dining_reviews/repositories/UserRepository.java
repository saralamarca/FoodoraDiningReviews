package com.example.foodora_dining_reviews.repositories;

import com.example.foodora_dining_reviews.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository interface for User entity, providing basic CRUD operations.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
