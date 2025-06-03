package com.springboot.lms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.lms.model.Course;
import com.springboot.lms.model.Learner;
import com.springboot.lms.model.LearnerCourse;
import com.springboot.lms.repo.CourseRepository;
import com.springboot.lms.repo.LearnerCourseRepository;
import com.springboot.lms.repo.LearnerRepository;
import com.springboot.lms.service.LearnerCourseService;

@SpringBootTest
class LearnerCourseServiceTest {

	@InjectMocks
	private LearnerCourseService learnerCourseService;
	@Mock
	private LearnerRepository learnerRepository;
	@Mock
	private LearnerCourseRepository learnerCourseRepository;
	@Mock
    private CourseRepository courseRepository;
	
	private Learner learner;
	private Course course;
	private LearnerCourse learnerCourse;

	@BeforeEach
	public void begin() {
		course = new Course();
		course.setId(1);
		course.setTitle("Core Java - Enterprise Development");
		course.setCredits(50);

		learner = new Learner();
		learner.setId(1);
		learner.setName("Harry Potter");
		learner.setContact("98667434344");

		learnerCourse = new LearnerCourse();
		learnerCourse.setId(25);
		learnerCourse.setLearner(learner);
		learnerCourse.setCourse(course);
		learnerCourse.setCouponCode("yyy");
		learnerCourse.setEnrollDate(LocalDate.now());

	}

	public void getCoursesByLearnerIdTest() {

		List<Course> expectedList = List.of(course);

		List<Course> actualList = learnerCourseService.getCourseByLearnerId(1);

		assertEquals(expectedList, actualList);
	}

//	@Test
	public void getCoursesByLearnerIdTestMock() {

		List<Course> expectedList = List.of(course);

		when(learnerRepository.findById(1)).thenReturn(Optional.of(learner));

		when(learnerCourseRepository.getCourseByLearnerId(1)).thenReturn(expectedList);

		List<Course> actualList = learnerCourseService.getCourseByLearnerId(1);

		assertEquals(expectedList, actualList);
	}

	@Test
	public void enrollLearnerInCourse() {
		LearnerCourse lc = new LearnerCourse();
		when(learnerRepository.findById(1)).thenReturn(Optional.of(learner));
		when(courseRepository.findById(1)).thenReturn(Optional.of(course));
		when(learnerCourseRepository.save(lc)).thenReturn(learnerCourse);
		assertEquals(learnerCourse, learnerCourseService.enrollLearnerInCourse(1, 1, lc));
	}
	
	@AfterEach
	public void end() {
		course=null;
		learner=null;
		learnerCourse=null;
	}

}
