package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.data.domain.Pageable;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;

import java.util.List;
import java.util.Optional;

public interface HallTicketService {

    List<HallTicket> getAllHallTickets(Pageable pageable);

    Optional<HallTicket> getHallTicketByHallTicketNumber(int hallTicketNumber);

    HallTicket createHallTicket(HallTicket hallTicket);

    String deleteHallTicket(int hallTicketNumber);

    String deleteAllHallTickets();

    HallTicket updateHallTicket(HallTicket hallTicket);

}
