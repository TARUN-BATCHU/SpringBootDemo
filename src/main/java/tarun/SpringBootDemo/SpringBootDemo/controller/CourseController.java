package tarun.SpringBootDemo.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;


    //get all course details
    @GetMapping("/")
    public List<Course> getAllCourses(Pageable pageable)
    {
        return courseService.getAllCourses(pageable);
    }

    // get course details by id
    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(@PathVariable int courseId)
    {
        return courseService.getCourseById(courseId);
    }

    //post course details
    @PostMapping("/")
    public Course createCourse(@RequestBody Course course)
    {
        Course savedCourse = courseService.createCourse(course);
        return savedCourse;
    }

    // delete course details by id
    @DeleteMapping("/{courseId}")
    public String deleteCourse(@PathVariable int courseId)
    {
        return courseService.deleteCourse(courseId);
    }

    // delete all courses
    @DeleteMapping("/")
    public String deleteCourses()
    {
        return courseService.deleteAllCourses();
    }

    @GetMapping("/{courseId}/users")
    public List<User> getUserByCourseId(@PathVariable int courseId)
    {
        return courseService.getUserByCourseId(courseId);
    }
}
