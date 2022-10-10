package tarun.SpringBootDemo.SpringBootDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;


    //get all course details
    @GetMapping("/course")
    public List<Course> getAllCourses()
    {
        return courseService.getAllCourses();
    }

    // get course details by id
    @GetMapping("course/{courseid}")
    public Optional<Course> getCourseById(@PathVariable int courseid)
    {
        return courseService.getCourseById(courseid);
    }

    //post course details
    @PostMapping("/course")
    public Course createCourse(@RequestBody Course course)
    {
        Course savedCourse = courseService.createCourse(course);
        return savedCourse;
    }

    // delete course details by id
    @RequestMapping("delete/course/{courseid}")
    public String deleteCourse(@PathVariable int courseid)
    {
        return courseService.deleteCourse(courseid);
    }

    // delete all courses
    @RequestMapping("delete/courses")
    public String deleteCourses()
    {
        return courseService.deleteAllCourses();
    }

    @GetMapping("course/users/{courseId}")
    public List<User> getUserByCourseId(@PathVariable int courseId)
    {
        return courseService.getUserByCourseId(courseId);
    }
}
