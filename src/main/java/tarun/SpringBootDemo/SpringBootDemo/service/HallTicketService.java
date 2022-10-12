package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.data.domain.Pageable;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;

import java.util.List;
import java.util.Optional;

public interface HallTicketService {

    List<HallTicket> getAllHallTickets(Pageable pageable);

    Optional<HallTicket> getHallTicketByHallTicketNumber(int HallTicketNumber);

    HallTicket createHallTicket(HallTicket hallTicket);

    String deleteHallTicket(int HallTicketNumber);

    String deleteAllHallTickets();

    HallTicket updateHallTicket(HallTicket hallTicket);

}
