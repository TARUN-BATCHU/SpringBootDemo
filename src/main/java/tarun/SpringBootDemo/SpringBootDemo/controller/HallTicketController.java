package tarun.SpringBootDemo.SpringBootDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tarun.SpringBootDemo.SpringBootDemo.entities.HallTicket;
import tarun.SpringBootDemo.SpringBootDemo.service.HallTicketService;
import tarun.SpringBootDemo.SpringBootDemo.service.HallTicketServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
public class HallTicketController extends HallTicketServiceImpl {

    @Autowired
    HallTicketService hallTicketService;

    //get all Hallticket details
    @GetMapping("/hallTicket")
    public List<HallTicket> getAllHallTickets()
    {
        return hallTicketService.getAllHallTickets();
    }

    // get hallTicket details by hallTicketNumber
    @GetMapping("hallTicket/{hallTicketNumber}")
    public Optional<HallTicket> getHallTicketByHallTicketNumber(@PathVariable int hallTicketNumber)
    {
        return hallTicketService.getHallTicketByHallTicketNumber(hallTicketNumber);
    }

    //post hallTicket details
    @PostMapping("/hallTicket")
    public HallTicket createHallTicket(@RequestBody HallTicket hallTicket)
    {
        HallTicket savedHallTicket = hallTicketService.createHallTicket(hallTicket);
        return savedHallTicket;
    }

    // delete hallTicket details by hallTicketNumber
    @RequestMapping("hallTicket/delete/{hallTicketNumber}")
    public String deletehallTicket(@PathVariable int hallTicketNumber)
    {
        return hallTicketService.deleteHallTicket(hallTicketNumber);
    }

    // delete all organizations
    @RequestMapping("hallTicket/delete")
    public String deletehallTicket()
    {
        return hallTicketService.deleteAllHallTickets();
    }


}
