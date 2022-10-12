package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(int id);
    List<User> getAllUsers(Pageable pageable);
    User createUser(User user);
    String deleteUserById(int id);
    String deleteAllUsers();
    User updateUser(User user);


}
