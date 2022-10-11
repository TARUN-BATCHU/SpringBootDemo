package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.Course;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(int id);
    List<User> getAllUsers(Pageable pageable);
    User createUser(User user);
    String deleteUserById(int id);
    String deleteAllUsers();
    User updateUser(User user);

    //List<User> GetUsersByDob(LocalDate Dob);



}
