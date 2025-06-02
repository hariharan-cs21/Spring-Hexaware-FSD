package com.springboot.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.lms.model.Learner;

public interface LearnerRepository extends JpaRepository<Learner, Integer> {

	@Query("select l from Learner l where l.user.username=?1")
	Learner getLearnerByUsername(String username);

}
