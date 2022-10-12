package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.exception.AlreadyExistsException;
import tarun.SpringBootDemo.SpringBootDemo.exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.repository.OrganizationRepository;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Organization> getAllOrganizations(Pageable pageable) {
        return organizationRepository.findAll(pageable).getContent().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Organization> getOrganizationById(int id) {
        return organizationRepository.findById(id);
    }

    @Override
    public Organization createOrganization(Organization organization) {
        Optional<Organization> org = organizationRepository.findByOrganizationName(organization.getOrganizationName());
        if(org != null) throw new AlreadyExistsException("ORGANIZATION WITH SAME NAME ALREADY EXISTS IN DATABASE");
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
    public List<User> getUsersByOrganizationId(int organizationId,Pageable pageable) {
        Optional<Organization> o = organizationRepository.findById(organizationId);
        if(o.isEmpty())
            throw new NotFoundException("There were no users in the organization with id:"+organizationId);
        return userRepository.findByOrganization(o,pageable);
    }

    @Override
    public List<User> getUsersByOrganizationName(String organizationName, Pageable pageable) {
        Optional<Organization> o1 = organizationRepository.findByOrganizationName(organizationName);
        return userRepository.findByOrganization(o1,pageable);
    }
}