package com.springboot.lms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.lms.model.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Query("select v from Video v where v.module.course.id=?1")
    List<Video> getAllVideosWithModules(int courseId);

}
