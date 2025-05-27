package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.Course;
import com.springboot.lms.repo.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;

	public CourseService(CourseRepository CourseService) {
		this.courseRepository = CourseService;
	}
	public Course addCourse(Course course) {
		return courseRepository.save(course);
	}
	public List<Course> getAll() {
		return courseRepository.findAll();
	}
	
}
