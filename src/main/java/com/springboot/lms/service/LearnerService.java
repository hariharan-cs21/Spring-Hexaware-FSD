package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.Learner;
import com.springboot.lms.repo.LearnerRepository;

@Service
public class LearnerService {
	private LearnerRepository learnerRepository;

	public LearnerService(LearnerRepository learnerRepository) {
		this.learnerRepository = learnerRepository;
	}

	public Learner insertLearner(Learner learner) { 
		return learnerRepository.save(learner);
	}

	public List<Learner> getAll() {
		return learnerRepository.findAll();
	}

	public void deletebyId(int id) {
		learnerRepository.deleteById(id);
	}

	public Learner getById(int id) {
		return learnerRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
	}
	public Learner updateLearner(int id,Learner updated) {
		Learner DbLearner= learnerRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		if(updated.getName()!=null) {
			DbLearner.setName(updated.getName());
		}
		if(updated.getContact()!=null) {
			DbLearner.setContact(updated.getContact());
		}
		return learnerRepository.save(DbLearner);
	}

}
