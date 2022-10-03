package tarun.SpringBootDemo.SpringBootDemo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tarun.SpringBootDemo.SpringBootDemo.exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.repository.OrganizationRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class OrganizationController {

    private OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationRepository organizationRepository)
    {
        this.organizationRepository = organizationRepository;
    }

    //get all organization details
    @GetMapping("/organization")
    public List<Organization> getAllOrganizations()
    {
        return organizationRepository.findAll();
    }

    // get organization details by id
    @GetMapping("organization/{id}")
    public Optional<Organization> getOrganizationById(@PathVariable int id)
    {
        Optional<Organization> organization = organizationRepository.findById(id);
        if(organization.isEmpty())
        {
            throw new NotFoundException("Organization of id : "+id+" was not found");
        }
        return organization;
    }

    //post organization details
    @PostMapping("/organization")
    public Organization createOrganization(@RequestBody Organization organization)
    {
        Organization savedOrganization = organizationRepository.save(organization);
        //URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrganization.getOrganizationId()).toUri();
        //return ResponseEntity.created(location).build();
        return savedOrganization;
    }

    // delete organization details by id
    @RequestMapping("delete/organization/{id}")
    public String deleteOrganization(@PathVariable int id)
    {
        organizationRepository.deleteById(id);
        return "Organization deleted with id : "+id+".";
    }

    // delete all organizations
    @RequestMapping("delete/organizations")
    public String deleteOrganizations()
    {
        organizationRepository.deleteAll();
        return "All organization details were deleted successfully";
    }
}
