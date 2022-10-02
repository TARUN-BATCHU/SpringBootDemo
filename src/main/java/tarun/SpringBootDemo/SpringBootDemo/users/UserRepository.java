package tarun.SpringBootDemo.SpringBootDemo.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

}
