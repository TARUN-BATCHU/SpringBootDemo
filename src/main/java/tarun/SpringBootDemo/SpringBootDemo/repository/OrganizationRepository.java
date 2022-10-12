package tarun.SpringBootDemo.SpringBootDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

   Optional<Organization> findByOrganizationName(String organizationName);

   Page<Organization> findAll(Pageable pageable);
}
