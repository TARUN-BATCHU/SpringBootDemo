package tarun.SpringBootDemo.SpringBootDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.service.OrganizationService;
import tarun.SpringBootDemo.SpringBootDemo.service.OrganizationServiceImpl;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@RestController
public class OrganizationController extends OrganizationServiceImpl {

    @Autowired
    OrganizationService organizationService;

    //get all organization details
    @GetMapping("/organization")
    public List<Organization> getAllOrganizations()
    {
        return organizationService.getAllOrganizations();
    }

    // get organization details by id
    @GetMapping("organization/{id}")
    public Optional<Organization> getOrganizationById(@PathVariable int id)
    {
        return organizationService.getOrganizationById(id);
    }

    //post organization details
    @PostMapping("/organization")
    public Organization createOrganization(@RequestBody Organization organization)
    {
        Organization savedOrganization = organizationService.createOrganization(organization);
        return savedOrganization;
    }

    // delete organization details by id
    @RequestMapping("delete/organization/{id}")
    public String deleteOrganization(@PathVariable int id)
    {
        return organizationService.deleteOrganization(id);
    }

    // delete all organizations
    @RequestMapping("delete/organizations")
    public String deleteOrganizations()
    {
        return organizationService.deleteAllOrganizations();
    }

    @GetMapping("users/organization/{organizationId}")
    public List<User> getUserByOrganizationId(@PathVariable int organizationId, Pageable pageable)
    {
        return organizationService.GetUsersByOrganizationId(organizationId, pageable);
    }

    @GetMapping("users/organizationName/{organizationName}")
    public List<User> getUserByOrganizationName(@PathVariable String organizationName, Pageable pageable)
    {
        return organizationService.GetUsersByOrganizationName(organizationName,pageable);
    }


}
