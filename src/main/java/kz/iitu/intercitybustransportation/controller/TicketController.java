package kz.iitu.intercitybustransportation.controller;
import kz.iitu.intercitybustransportation.dto.TicketDTO;
import kz.iitu.intercitybustransportation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}")
    public TicketDTO getTicket(@PathVariable Long id) {
        return ticketService.getTicket(id);
    }

    @GetMapping
    public List<TicketDTO> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @PostMapping
    public TicketDTO createTicket(@RequestBody TicketDTO ticketDto) {
        return ticketService.createTicket(ticketDto);
    }

    @PutMapping("/{id}")
    public TicketDTO updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDto) {
        return ticketService.updateTicket(id, ticketDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
    }
}
