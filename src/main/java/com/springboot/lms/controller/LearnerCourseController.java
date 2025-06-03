package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.*;
import com.springboot.lms.service.LearnerCourseService;

@RestController
public class LearnerCourseController {
	@Autowired
	private LearnerCourseService learnerCourseService;
	@PostMapping("/api/learner/enroll/course/{learnerId}/{courseId}")
	public LearnerCourse enrollLearnerInCourse(
									@PathVariable int learnerId, 
									  @PathVariable int courseId, 
									  @RequestBody LearnerCourse learnerCourse) {
		return learnerCourseService.enrollLearnerInCourse(learnerId,courseId,learnerCourse);
	}
	@GetMapping("/api/learner/enroll/course/{courseId}")
	public List<?> getLearnerByCourseId(@PathVariable int courseId) {
		return learnerCourseService.getLearnerByCourseId(courseId);
	}
	@GetMapping("/api/learner/enroll/{learnerId}")
	public ResponseEntity<?> getCourseByLearnerId(@PathVariable int learnerId) {
		return ResponseEntity.status(HttpStatus.OK).body(learnerCourseService.getCourseByLearnerId(learnerId));
		
	}
}
