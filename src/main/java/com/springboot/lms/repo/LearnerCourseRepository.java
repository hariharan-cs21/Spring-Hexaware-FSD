package com.springboot.lms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.lms.model.LearnerCourse;

public interface LearnerCourseRepository extends JpaRepository<LearnerCourse, Integer> {
	@Query("select lc from LearnerCourse lc where lc.learner.id=?1 and lc.course.id=?2")
	Optional<LearnerCourse> getUsingJPQL(int learnerId, int courseId);


}
