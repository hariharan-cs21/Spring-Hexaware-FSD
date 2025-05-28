package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.model.Review;
import com.springboot.lms.repo.CourseRepository;
import com.springboot.lms.repo.LearnerCourseRepository;
import com.springboot.lms.repo.LearnerRepository;
import com.springboot.lms.repo.ReviewRepository;

@Service
public class ReviewService {
	private ReviewRepository reviewRepository;
	private CourseRepository courseRepository;
	private LearnerRepository learnerRepository;
	private LearnerCourseRepository learnerCourseRepository;

	public ReviewService(ReviewRepository reviewRepository, CourseRepository courseRepository,
			LearnerRepository learnerRepository, LearnerCourseRepository learnerCourseRepository) {
		this.reviewRepository = reviewRepository;
		this.courseRepository = courseRepository;
		this.learnerRepository = learnerRepository;
		this.learnerCourseRepository = learnerCourseRepository;
	}

	public Review postReview(int learnerId, int courseId, Review review) {
		LearnerCourse learnerCourse = learnerCourseRepository.getUsingJPQL(learnerId, courseId)
				.orElseThrow(() -> new RuntimeException("Learner not enrolled in course"));

		review.setLearnerCourse(learnerCourse);

		return reviewRepository.save(review);
	}

	public List<Review> getReviews(String value) {
		return reviewRepository.findByRatingGreaterThanEqual(value);
	}
}
