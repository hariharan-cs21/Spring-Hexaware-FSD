package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.lms.model.CModule;
import com.springboot.lms.model.Video;
import com.springboot.lms.repo.ModuleRepository;
import com.springboot.lms.repo.VideoRepository;

@Service
public class VideoService {
	private VideoRepository videoRepository;
	private ModuleRepository moduleRepository;

	public VideoService(VideoRepository videoRepository, ModuleRepository moduleRepository) {
		this.videoRepository = videoRepository;
		this.moduleRepository = moduleRepository;
	}

	@Transactional
	public List<Video> addAll(int moduleId, List<Video> videos) {
		CModule module = moduleRepository.findById(moduleId)
				.orElseThrow(() -> new RuntimeException("Module not found"));
		if (videos.isEmpty())
			throw new RuntimeException("No Data Found");
		videos.parallelStream().forEach(v -> v.setModule(module));
		return videoRepository.saveAll(videos);
	}

}
