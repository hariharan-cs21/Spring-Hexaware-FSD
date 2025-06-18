package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.model.Review;
import com.springboot.lms.repo.LearnerCourseRepository;
import com.springboot.lms.repo.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository reviewRepository;

	private LearnerCourseRepository learnerCourseRepository;

	public ReviewService(ReviewRepository reviewRepository, LearnerCourseRepository learnerCourseRepository) {
		this.reviewRepository = reviewRepository;

		this.learnerCourseRepository = learnerCourseRepository;
	}

	public Review postReview(int learnerId, int courseId, Review review) {
		System.out.println(learnerId + " " + courseId);
		LearnerCourse learnerCourse = learnerCourseRepository.getUsingJPQL(learnerId, courseId)
				.orElseThrow(() -> new RuntimeException("Learner not enrolled in course"));

		review.setLearnerCourse(learnerCourse);

		return reviewRepository.save(review);
	}

	public List<Review> getReviews(String value) {
		return reviewRepository.findByRatingGreaterThanEqual(value);
	}

	public List<Review> getReviewByCourseId(int courseId) {
		return reviewRepository.getReviewByCourseId(courseId);
	}
}
