package tarun.SpringBootDemo.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.service.UserService;
import tarun.SpringBootDemo.SpringBootDemo.service.UserServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController extends UserServiceImpl {

    @Autowired
    UserService userService;

    //get all users details
    @GetMapping("/user")
    public List<User> getAllUsers(Pageable pageable)
    {
        return userService.getAllUsers(pageable);
    }

    //get user details by user id
    @GetMapping("user/{id}")
    public Optional<User> getUserById(@PathVariable int id)
    {
        return userService.getUserById(id);
    }

    // post user details
    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    // delete user details by id
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id)
    {
        return userService.deleteUserById(id);
    }

    // delete all users
    @DeleteMapping("/user")
    public String deleteAllUsers()
    {
        return userService.deleteAllUsers();
    }


    // update users by id
    @PutMapping("/user")
    public User updateUser(@RequestBody User user)
    {
        return userService.updateUser(user);
    }

}