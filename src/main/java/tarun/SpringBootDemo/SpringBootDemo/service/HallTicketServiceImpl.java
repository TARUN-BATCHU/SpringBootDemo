package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.repository.HallTicketRepository;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HallTicketServiceImpl implements HallTicketService{

    @Autowired
    HallTicketRepository hallTicketRepository;


    @Override
    public List<HallTicket> getAllHallTickets() {
        return hallTicketRepository.findAll();
    }

    @Override
    public Optional<HallTicket> getHallTicketByHallTicketNumber(int HallTicketNumber) {
        return hallTicketRepository.findById(HallTicketNumber);
    }

    @Override
    public HallTicket createHallTicket(HallTicket hallTicket) {
        HallTicket h = hallTicketRepository.save(hallTicket);
        return h;
    }

    @Override
    public String deleteHallTicket(int HallTicketNumber) {
        hallTicketRepository.deleteById(HallTicketNumber);
        return "Hall Ticket deleted with number : "+HallTicketNumber+".";
    }

    @Override
    public String deleteAllHallTickets() {
        hallTicketRepository.deleteAll();
        return "All hall Tickets were deleted";
    }

    @Override
    public HallTicket updateHallTicket(HallTicket hallTicket) {
        return hallTicketRepository.save(hallTicket);
    }

}
