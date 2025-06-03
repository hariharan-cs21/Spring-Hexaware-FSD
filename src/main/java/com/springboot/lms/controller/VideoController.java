package com.springboot.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.lms.model.Video;
import com.springboot.lms.service.VideoService;

@RestController
@RequestMapping("/api/video")
public class VideoController {
	@Autowired
    private VideoService videoService;
	
	@PostMapping("/add/{moduleId}")
	public ResponseEntity<?>addAll(@PathVariable int moduleId,@RequestBody List<Video>list){
		videoService.addAll(moduleId,list);
		return ResponseEntity.status(HttpStatus.OK).body("Videos added successfully");
	}
}
