package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.data.domain.Pageable;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    List<Course> getAllCourses(Pageable pageable);

    Optional<Course> getCourseById(int courseId);

    Course createCourse(Course course);

    String deleteCourse(int courseId);

    String deleteAllCourses();

    Course updateCourse(Course course);

    List<User> getUserByCourseId(int courseId);


}
