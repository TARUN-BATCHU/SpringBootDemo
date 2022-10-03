package tarun.SpringBootDemo.SpringBootDemo.users;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tarun.SpringBootDemo.SpringBootDemo.Exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.organization.Organization;
import tarun.SpringBootDemo.SpringBootDemo.organization.OrganizationRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepository;
    private OrganizationRepository organizationRepository;

    public UserController(UserRepository userRepository, OrganizationRepository organizationRepository)
    {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

    //get all users details
    @GetMapping("/users")
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    //get user details by user id
    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
        {
            throw new NotFoundException("User with id : "+id+" was not found");
        }
        return user;
    }

    // post user details
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // delete user details by id
    @DeleteMapping("delete/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    // delete all users
    @DeleteMapping("delete/users")
    public void deleteUsers()
    {
        userRepository.deleteAll();
    }

    // get all users by organization id
    @GetMapping("/users/Organization/{OrganizationId}")
    public List<User> retrieveUsersForOrganizationId(@PathVariable int OrganizationId)
    {
        Optional<Organization> organization = organizationRepository.findById(OrganizationId);
        if(organization.isEmpty())
            throw new NotFoundException("There were no users in the organization with id:"+OrganizationId);
        return organization.get().getUser();
    }

    // get all users by organization name
//    @GetMapping("/users/OrganizationName/{OrganizationName}")
//    public List<User> retrieveUsersForOrganizationName(@PathVariable String OrganizationName)
//    {
//        Optional<Organization> organization = organizationRepository.findByOrganizationName(OrganizationName);
//        if(organization.isEmpty())
//            throw new NotFoundException("There were no users in the organization with Name:"+OrganizationName);
//        return organization.get().getUser();
//    }


    // update users by id
//    @PutMapping("/users/{UserId}")
//    public ResponseEntity<User> UpdateUser(@RequestBody User user, @PathVariable int UserId)
//    {
//        User savedUser = userRepository.updateUser(UserId, user);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{UserId}").buildAndExpand(savedUser.getUserId()).toUri();
//        return ResponseEntity.created(location).build();
//    }
}
