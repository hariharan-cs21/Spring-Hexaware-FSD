package com.springboot.lms.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Course;
import com.springboot.lms.service.CourseService;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:5173")
public class CourseController {
	@Autowired
	private CourseService courseService;
	@PostMapping("/add")
	public Course addCourse(Principal principal, @RequestBody Course course) {
		String username = principal.getName();
		return courseService.addCourse(course,username);
	}
	@GetMapping("/getAll")
	public List<Course> getAll(@RequestParam(name = "page",defaultValue = "0",required = false) Integer page,
			@RequestParam(name = "size",defaultValue = "1000",required = false) Integer size) {
		return courseService.getAll(page,size);
	}
	
	@GetMapping("/by-author")
	public List<Course> getCoursesByAuthor(Principal principal) {
		String username = principal.getName(); 
		List<Course> courses = courseService.getCoursesByAuthor(username);
		return courses;
	}
	
	
}
