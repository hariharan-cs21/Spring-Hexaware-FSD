package com.springboot.lms.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.lms.model.Course;
import com.springboot.lms.model.Learner;
import com.springboot.lms.model.LearnerCourse;

public interface LearnerCourseRepository extends JpaRepository<LearnerCourse, Integer> {
	@Query("select lc from LearnerCourse lc where lc.learner.id=?1 and lc.course.id=?2")
	Optional<LearnerCourse> getUsingJPQL(int learnerId, int courseId);

	@Query("select lc.learner from LearnerCourse lc where lc.course.id=?1")
	List<Learner> getLearnerByCourseId(int courseId);
	
	@Query("select lc.course from LearnerCourse lc where lc.learner.id=?1")
	List<Course> getCourseByLearnerId(int leanerId);

}
