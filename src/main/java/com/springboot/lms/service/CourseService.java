package com.springboot.lms.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.lms.model.Author;
import com.springboot.lms.model.Course;
import com.springboot.lms.repo.AuthorRepository;
import com.springboot.lms.repo.CourseRepository;

@Service
public class CourseService {
	
	private CourseRepository courseRepository;
	private AuthorRepository authorRepository;
	public CourseService(CourseRepository CourseService,AuthorRepository authorRepository) {
		this.courseRepository = CourseService;
		this.authorRepository=authorRepository;
	}
	public Course addCourse(Course course,String username) {
		Author author = authorRepository.getAuthorByUsername(username);
		course.setAuthor(author);
		return courseRepository.save(course);
	}
	public List<Course> getAll(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
		return courseRepository.findAll(pageable).getContent();
	}
	
}
