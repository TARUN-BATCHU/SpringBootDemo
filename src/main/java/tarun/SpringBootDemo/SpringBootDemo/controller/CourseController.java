package tarun.SpringBootDemo.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;


    //get all course details
    @GetMapping("/")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    // get course details by id
    @GetMapping("/{courseid}")
    public Optional<Course> getCourseById(@PathVariable int courseid)
    {
        return courseService.getCourseById(courseid);
    }

    //post course details
    @PostMapping("/")
    public Course createCourse(@RequestBody Course course)
    {
        Course savedCourse = courseService.createCourse(course);
        return savedCourse;
    }

    // delete course details by id
    @DeleteMapping("/{courseid}")
    public String deleteCourse(@PathVariable int courseid)
    {
        return courseService.deleteCourse(courseid);
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
