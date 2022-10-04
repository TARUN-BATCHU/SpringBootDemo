package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.repository.OrganizationRepository;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Organization> getAllOrganizations() {
        return organizationRepository.findAll();
    }

    @Override
    public Optional<Organization> getOrganizationById(int id) {
        return organizationRepository.findById(id);
    }

    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public String deleteOrganization(int id) {
        organizationRepository.deleteById(id);
        return "Organization details deleted with id:" + id + ".";
    }

    @Override
    public String deleteAllOrganizations() {
        organizationRepository.deleteAll();
        return "All organization details were deleted successfully";
    }

    @Override
    public Organization updateOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<User> GetUsersByOrganizationId(int organizationId,Pageable pageable) {
        Optional<Organization> o = organizationRepository.findById(organizationId);
        return userRepository.findByOrganization(o,pageable);
    }

    @Override
    public List<User> GetUsersByOrganizationName(String organizationName, Pageable pageable) {
        Optional<Organization> o1 = organizationRepository.findByOrganizationName(organizationName);
        return userRepository.findByOrganization(o1,pageable);
    }
}