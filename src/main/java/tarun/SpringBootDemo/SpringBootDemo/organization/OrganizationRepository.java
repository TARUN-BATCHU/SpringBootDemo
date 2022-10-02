package tarun.SpringBootDemo.SpringBootDemo.organization;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tarun.SpringBootDemo.SpringBootDemo.users.User;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;


public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

}
