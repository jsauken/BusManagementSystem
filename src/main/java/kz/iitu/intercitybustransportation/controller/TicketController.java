package kz.iitu.intercitybustransportation.controller;
import kz.iitu.intercitybustransportation.dto.TicketDTO;
import kz.iitu.intercitybustransportation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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


    @PostMapping("/book/{userId}")
    public ResponseEntity<TicketDTO> bookTicket(@PathVariable Long userId, @RequestBody TicketDTO ticketDto) {
        TicketDTO bookedTicket = ticketService.bookTicket(userId, ticketDto);
        return ResponseEntity.ok(bookedTicket);
    }

    @GetMapping("/book/{flightId}/{seatNumber}")
    public ResponseEntity<TicketDTO> bookTicket(@PathVariable Long flightId, @PathVariable int seatNumber) throws IOException {
        TicketDTO bookedTicket = ticketService.bookTicketForFlight(flightId, seatNumber);
        return ResponseEntity.ok(bookedTicket);
    }


    @GetMapping("/book/{ticketId}/cancel}")
    public ResponseEntity<String> cancelTicket(@PathVariable Long ticketId) throws IOException {
        ticketService.cancelTicket(ticketId);
        return ResponseEntity.ok("Ticket with id " + ticketId + " has been cancelled");
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
