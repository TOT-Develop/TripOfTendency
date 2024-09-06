package totreviews.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import totreviews.dao.CourseDAO;
import totreviews.domain.CourseDTO;
import totreviews.domain.CourseResDTO;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDAO;

	@Override
	public CourseDTO getCourseById(String courseId) {
		return courseDAO.getCourseById(courseId);
	}

	@Override
	public List<CourseDTO> getCourseDetailsByMemId(String memId) {
		List<CourseDTO> courseList = courseDAO.getCourseByMemId(memId);

		for (CourseDTO course : courseList) {
			List<CourseResDTO> courseDetails = new ArrayList<>();
			String[] courseTypes = course.getDcourse().split(",");
			for (String courseType : courseTypes) {
				String[] typeAndId = courseType.split(":");
				CourseResDTO courseDetail = courseDAO.getCourseDetailsById(typeAndId[0],
						Integer.parseInt(typeAndId[1]));
				courseDetails.add(courseDetail);
			}
			course.setCourseDetail(courseDetails);
		}

		return courseList;
	}

}
