package tarun.SpringBootDemo.SpringBootDemo.service;
import org.springframework.data.domain.Pageable;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrganizationService {

    List<Organization> getAllOrganizations();

    Optional<Organization> getOrganizationById(int id);

    Organization createOrganization(Organization organization);

    String deleteOrganization(int id);

    String deleteAllOrganizations();

    Organization updateOrganization(Organization organization);

    List<User> getUsersByOrganizationId(int organizationId,Pageable pageable);

    List<User> getUsersByOrganizationName(String organizationName, Pageable pageable);



}
