package totreviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import totreviews.domain.CourseDTO;
import totreviews.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRestController {

	@Autowired
	private CourseService courseService;

	@GetMapping("/{courseId}")
	public CourseDTO getCourseById(@PathVariable("courseId") String courseId) {
		return courseService.getCourseById(courseId);
	}

}
