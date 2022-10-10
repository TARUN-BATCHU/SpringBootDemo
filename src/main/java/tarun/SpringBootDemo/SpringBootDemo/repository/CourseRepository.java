package tarun.SpringBootDemo.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
