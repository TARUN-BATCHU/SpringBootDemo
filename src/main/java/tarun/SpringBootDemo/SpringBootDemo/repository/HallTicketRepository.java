package tarun.SpringBootDemo.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;

public interface HallTicketRepository extends JpaRepository<HallTicket, Integer> {

}
