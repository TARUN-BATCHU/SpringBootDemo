package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.repository.CourseRepository;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(int courseid) {
        return courseRepository.findById(courseid);
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public String deleteCourse(int courseid) {
        courseRepository.deleteById(courseid);
        return "Course deleted";
    }

    @Override
    public String deleteAllCourses() {
        courseRepository.deleteAll();
        return "All courses deleted";
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<User> getUserByCourseId(int courseId) {
        Optional<Course> c = courseRepository.findById(courseId);
        return userRepository.findByCourse(c);
    }
}
