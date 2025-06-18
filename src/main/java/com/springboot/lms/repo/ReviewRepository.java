package com.springboot.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.lms.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	List<Review> findByRatingGreaterThanEqual(String rating);

	@Query("select r from Review r where r.learnerCourse.course.id=?1")
	List<Review> getReviewByCourseId(int courseId);
}
