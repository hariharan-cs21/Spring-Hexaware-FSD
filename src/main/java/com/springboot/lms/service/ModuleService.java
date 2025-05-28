package com.springboot.lms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.lms.model.CModule;
import com.springboot.lms.model.Course;
import com.springboot.lms.repo.CourseRepository;
import com.springboot.lms.repo.ModuleRepository;

@Service
public class ModuleService {
	private ModuleRepository moduleRepository;
	private CourseRepository courseRepository;

	public ModuleService(ModuleRepository moduleRepository, CourseRepository courseRepository) {
		this.moduleRepository = moduleRepository;
		this.courseRepository=courseRepository;
	}
	
	public CModule addModule(int id, CModule cModule) {
		Course course=courseRepository.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		cModule.setCourse(course);
		return moduleRepository.save(cModule);
		
	}
	public List<CModule> getModuleByCourseId(int courseId) {
		Course course=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Id not found"));
		return moduleRepository.getModuleByCourseId(courseId);
	}


}
