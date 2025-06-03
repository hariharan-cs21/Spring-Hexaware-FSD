package com.springboot.lms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.lms.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}
