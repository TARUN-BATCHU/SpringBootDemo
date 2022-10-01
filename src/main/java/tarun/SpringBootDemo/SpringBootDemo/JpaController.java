package tarun.SpringBootDemo.SpringBootDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tarun.SpringBootDemo.SpringBootDemo.organization.OrganizationRepository;
import tarun.SpringBootDemo.SpringBootDemo.users.User;
import tarun.SpringBootDemo.SpringBootDemo.users.UserRepository;

import java.util.List;

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
}
