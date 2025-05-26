package com.springboot.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.lms.model.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Integer> {

}
