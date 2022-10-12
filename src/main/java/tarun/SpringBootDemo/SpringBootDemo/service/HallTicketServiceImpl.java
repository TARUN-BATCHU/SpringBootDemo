package tarun.SpringBootDemo.SpringBootDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;
import tarun.SpringBootDemo.SpringBootDemo.entities.User;
import tarun.SpringBootDemo.SpringBootDemo.exception.NotFoundException;
import tarun.SpringBootDemo.SpringBootDemo.repository.HallTicketRepository;
import tarun.SpringBootDemo.SpringBootDemo.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HallTicketServiceImpl implements HallTicketService{

    @Autowired
    HallTicketRepository hallTicketRepository;


    @Override
    public List<HallTicket> getAllHallTickets(Pageable pageable) {
        return hallTicketRepository.findAll(pageable).getContent().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<HallTicket> getHallTicketByHallTicketNumber(int HallTicketNumber) {
        Optional<HallTicket> hall = hallTicketRepository.findById(HallTicketNumber);
        if(hall.isEmpty())
            throw new NotFoundException("No HallTicket exists with given Number");
        return hall;
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
