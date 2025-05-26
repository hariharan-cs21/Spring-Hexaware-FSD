package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Learner;
import com.springboot.lms.service.LearnerService;

@RestController
public class LearnerController {
	@Autowired
	private LearnerService learnerService;
	
	
	@PostMapping("/api/learner/add")
	public Learner insertLearner(@RequestBody Learner learner) {
		return learnerService.insertLearner(learner);
	}
	@GetMapping("/api/learner/getAll")
	public List<Learner> getAll() {
		return learnerService.getAll();
	}
	@DeleteMapping("/api/learner/delete/{id}")
	public void deleteById(@PathVariable int id) {
		learnerService.deletebyId(id);
	}
	@GetMapping("/api/learner/get/{id}")
	public Learner getById(@PathVariable int id) {
		return learnerService.getById(id);
	}
	@PutMapping("/api/learner/update/{id}")
	public Learner updateLearner(@PathVariable int id,@RequestBody Learner learner) {
		return learnerService.updateLearner(id,learner);
	}


}
