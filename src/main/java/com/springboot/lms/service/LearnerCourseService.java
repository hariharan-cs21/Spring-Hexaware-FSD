package com.springboot.lms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.lms.dto.LearnerDto;
import com.springboot.lms.model.Course;
import com.springboot.lms.model.Learner;
import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.repo.CourseRepository;
import com.springboot.lms.repo.LearnerCourseRepository;
import com.springboot.lms.repo.LearnerRepository;

@Service


public class LearnerCourseService {
	private CourseRepository courseRepository;
	private LearnerRepository learnerRepository;
	private LearnerCourseRepository learnerCourseRepository;
	@Autowired
	private LearnerDto learnerDto;
	
	public LearnerCourseService(CourseRepository courseRepository, LearnerRepository learnerRepository,
			LearnerCourseRepository learnerCourseRepository) {
		super();
		this.courseRepository = courseRepository;
		this.learnerRepository = learnerRepository;
		this.learnerCourseRepository = learnerCourseRepository;
	}

	public LearnerCourse enrollLearnerInCourse(int learnerId, int courseId, LearnerCourse learnerCourse) {
		 Learner learner = learnerRepository.findById(learnerId)
		 	.orElseThrow(()-> new RuntimeException("Learner ID Invalid"));
		 
		Course course = courseRepository.findById(courseId)
		.orElseThrow(()-> new RuntimeException("Course ID Invalid"));
		
		learnerCourse.setEnrollDate(LocalDate.now());
		
		learnerCourse.setLearner(learner);
		learnerCourse.setCourse(course);
		
		return learnerCourseRepository.save(learnerCourse);
	}
	public List<LearnerDto> getLearnerByCourseId(int courseId) {
		List<Learner> list = learnerCourseRepository.getLearnerByCourseId(courseId);
		 return learnerDto.convertLeanerIntoDto(list);
	}
	public List<Course>getCourseByLearnerId(int learnerID) {
		learnerRepository.findById(learnerID).orElseThrow(()->new RuntimeException("Learner Id invalid"));
		 List<Course>list= learnerCourseRepository.getCourseByLearnerId(learnerID);
		 if(list!=null && list.isEmpty()) {
			 throw new RuntimeException("You are not enrolled in any course");
		 }
		 return list;
		 
	}
	
	
}
