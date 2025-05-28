package com.springboot.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	List<Review>findByRatingGreaterThanEqual(String rating);
}
