package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.exception.AlreadyExistsException;
import tarun.SpringBootDemo.SpringBootDemo.exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getUserById(int id) {
        Optional<User> u = userRepository.findById(id);
        if(u.isEmpty()){
            throw new NotFoundException("There were no users in the organization with id:"+id);}
        return u;
    }

    @Override
    public List<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).getContent().stream().collect(Collectors.toList());
    }

    @Override
    public User createUser(User user) {
        User u3 = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(u3 == null){return userRepository.save(user);}
        else{throw new AlreadyExistsException("USER EMAIL ALREADY EXISTS IN DATABASE");}
    }

    @Override
    public String deleteUserById(int id) {
        Optional<User> us = userRepository.findById(id);
        if(us.isEmpty()){
            throw new NotFoundException("CANT DELETE, As user with given id not exists");}
        else{
            userRepository.deleteById(id);}
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
