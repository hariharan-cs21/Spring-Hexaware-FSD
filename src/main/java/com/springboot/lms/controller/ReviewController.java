package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Review;
import com.springboot.lms.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	
	
	@PostMapping("/add/{learnerId}/{courseId}")
	public Review postReview(@PathVariable int  learnerId, 
						   @PathVariable int  courseId, 
						   @RequestBody Review review) {
		
		return reviewService.postReview(learnerId,courseId, review);
	}
	
	//get all reviews with rating more than the given value
	@GetMapping("/getReview")
	public List<Review>getReviews(@RequestParam("rating") String value){
		return reviewService.getReviews(value);
	}
	
}
