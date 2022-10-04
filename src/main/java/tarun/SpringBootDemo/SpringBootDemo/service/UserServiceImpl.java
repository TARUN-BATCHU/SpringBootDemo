package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User deleted with id: "+id+".";
    }

    @Override
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All Users details were deleted";
    }

    @Override
    public User updateUser(User user) {
        userRepository.save(user);
        System.out.println("User updated successfully");
        return user;
    }


}
