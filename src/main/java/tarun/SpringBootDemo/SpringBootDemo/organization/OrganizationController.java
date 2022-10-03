package tarun.SpringBootDemo.SpringBootDemo.organization;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tarun.SpringBootDemo.SpringBootDemo.Exception.NotFoundException;

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
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization)
    {
        Organization savedOrganization = organizationRepository.save(organization);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrganization.getOrganizationId()).toUri();
        return ResponseEntity.created(location).build();
    }

    // delete organization details by id
    @DeleteMapping("delete/organization/{id}")
    public void deleteOrganization(@PathVariable int id)
    {
        organizationRepository.deleteById(id);
    }

    // delete all organizations
    @DeleteMapping("delete/organizations")
    public void deleteOrganizations()
    {
        organizationRepository.deleteAll();
    }
}
