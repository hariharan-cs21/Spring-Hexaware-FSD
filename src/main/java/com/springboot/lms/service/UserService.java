package com.springboot.lms.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.lms.model.Author;
import com.springboot.lms.model.User;
import com.springboot.lms.repo.AuthorRepository;
import com.springboot.lms.repo.LearnerRepository;
import com.springboot.lms.repo.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private LearnerRepository learnerRepository;
	private AuthorRepository authorRepository;
	private PasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,LearnerRepository learnerRepository,
			AuthorRepository authorRepository
			) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.learnerRepository=learnerRepository;
		this.authorRepository=authorRepository;
	}

	public User signUp(User user) {
		String plainPassword = user.getPassword(); 
		String encodedPassword =  passwordEncoder.encode(plainPassword);
		user.setPassword(encodedPassword);
		return userRepository.save(user);
	}

	public Object getUserInfo(String username) {
		User user=userRepository.getByUsername(username);
		switch(user.getRole().toUpperCase()) {
			case "LEARNER":
				return learnerRepository.getLearnerByUsername(username);
			case "AUTHOR":
				Author author=authorRepository.getAuthorByUsername(username);
				if(author.isActive()) return author;
				else throw new RuntimeException("Author is not active");
			case "EXECUTIVE":
				return null;
			default:
				return null;
		}
	}
	
	
}