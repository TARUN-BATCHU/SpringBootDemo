package tarun.SpringBootDemo.SpringBootDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tarun.SpringBootDemo.SpringBootDemo.Exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.organization.Organization;
import tarun.SpringBootDemo.SpringBootDemo.organization.OrganizationRepository;
import tarun.SpringBootDemo.SpringBootDemo.users.User;
import tarun.SpringBootDemo.SpringBootDemo.users.UserRepository;

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



}
