package tarun.SpringBootDemo.SpringBootDemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tarun.SpringBootDemo.SpringBootDemo.Exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.organization.Organization;
import tarun.SpringBootDemo.SpringBootDemo.organization.OrganizationRepository;
import tarun.SpringBootDemo.SpringBootDemo.users.User;
import tarun.SpringBootDemo.SpringBootDemo.users.UserRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class JpaController {

    private UserRepository userRepository;
    private OrganizationRepository organizationRepository;

    public JpaController(UserRepository userRepository, OrganizationRepository organizationRepository)
    {
        this.userRepository = userRepository;
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/users")
    public List<User> GetAllUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/organization")
    public List<Organization> GetAllOrganizations()
    {
        return organizationRepository.findAll();
    }

    @GetMapping("users/{id}")
    public Optional<User> GetUserById(@PathVariable int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty())
        {
            throw new NotFoundException("User with id : "+id+" was not found");
        }
        return user;
    }

    @GetMapping("organization/{id}")
    public Optional<Organization> GetOrganizationById(@PathVariable int id)
    {
        Optional<Organization> organization = organizationRepository.findById(id);
        if(organization.isEmpty())
        {
            throw new NotFoundException("Organization of id : "+id+" was not found");
        }
        return organization;
    }

    @PostMapping("/users")
    public ResponseEntity<User> CreateUser(@RequestBody User user)
    {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/organization")
    public ResponseEntity<Organization> CreateOrganization(@RequestBody Organization organization)
    {
        Organization savedOrganization = organizationRepository.save(organization);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrganization.getOrganizationId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("delete/users/{id}")
    public void DeleteUser(@PathVariable int id)
    {
        userRepository.deleteById(id);
    }

    @DeleteMapping("delete/organization/{id}")
    public void DeleteOrganization(@PathVariable int id)
    {
        organizationRepository.deleteById(id);
    }

    @DeleteMapping("delete/users")
    public void DeleteUsers()
    {
        userRepository.deleteAll();
    }

    @DeleteMapping("delete/organizations")
    public void DeleteOrganizations()
    {
        organizationRepository.deleteAll();
    }




}
