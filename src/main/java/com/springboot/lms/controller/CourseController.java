package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Course;
import com.springboot.lms.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@PostMapping("/add")
	public Course addCourse(@RequestBody Course course) {
		return courseService.addCourse(course);
	}
	@GetMapping("/getAll")
	public List<Course> getAll() {
		return courseService.getAll();
	}
	
}
