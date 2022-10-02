package tarun.SpringBootDemo.SpringBootDemo.organization;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tarun.SpringBootDemo.SpringBootDemo.users.User;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

   // Optional<Organization> findByOrganizationName(String organizationName);
}
