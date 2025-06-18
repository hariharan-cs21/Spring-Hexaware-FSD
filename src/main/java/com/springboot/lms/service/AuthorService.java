package com.springboot.lms.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.lms.model.Author;
import com.springboot.lms.model.User;
import com.springboot.lms.repo.AuthorRepository;

@Service
public class AuthorService {
	private AuthorRepository authorRepository;
	private UserService userService;

	public AuthorService(AuthorRepository authorRepository, UserService userService) {
		this.authorRepository = authorRepository;
		this.userService = userService;
	}

	public Author insertAuthor(Author author) {
		User user = author.getUser();

		user.setRole("AUTHOR");
		user = userService.signUp(user);
		author.setUser(user);
		author.setActive(true);
		return authorRepository.save(author);
	}

	public Author uploadProfilePic(String name, MultipartFile file) throws IOException {
		Author author = authorRepository.getAuthorByUsername(name);
		String originalFIle = file.getOriginalFilename();
		String extension = originalFIle.split("\\.")[1];

		if (!(List.of("jpg", "jpeg", "png", "svg", "gif").contains(extension.toLowerCase()))) {
			throw new RuntimeException(
					"Invalid File Type: " + extension + ", Upload only" + List.of("jpg", "jpeg", "png", "svg", "gif"));
		}
		String uploadFolder = "C:\\Users\\hari0\\Desktop\\Hex-React\\Hex-react\\public\\images";
		Files.createDirectories(Path.of(uploadFolder));
		Path path = Paths.get(uploadFolder, originalFIle);
		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		author.setProfilePic(originalFIle);

		return authorRepository.save(author);
	}

	public Author getAuthorInfo(String name) {
		return authorRepository.getAuthorByUsername(name);
	}

}
