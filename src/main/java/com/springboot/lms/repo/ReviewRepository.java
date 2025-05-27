package com.springboot.lms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
}
