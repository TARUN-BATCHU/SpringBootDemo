package tarun.SpringBootDemo.SpringBootDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByOrganization(Optional<Organization> organization, Pageable pageable);
    List<User> findByCourse(Optional<Course> course);

    Page<User> findAll(Pageable pageable);

}
