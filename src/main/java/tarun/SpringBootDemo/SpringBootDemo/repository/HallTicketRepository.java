package tarun.SpringBootDemo.SpringBootDemo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;
import tarun.SpringBootDemo.SpringBootDemo.entities.Organization;

public interface HallTicketRepository extends JpaRepository<HallTicket, Integer> {

    Page<HallTicket> findAll(Pageable pageable);
}
