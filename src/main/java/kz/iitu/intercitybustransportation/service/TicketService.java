package kz.iitu.intercitybustransportation.service;

import kz.iitu.intercitybustransportation.dto.TicketDTO;

import java.io.IOException;
import java.util.List;

public interface TicketService {
    TicketDTO getTicket(Long id);
    List<TicketDTO> getAllTickets();
    TicketDTO createTicket(TicketDTO ticketDto);
    TicketDTO updateTicket(Long id, TicketDTO ticketDto);
    void deleteTicket(Long id);

    TicketDTO bookTicket(Long userId, TicketDTO ticketDto);
    TicketDTO bookTicketForFlight(Long flightId, Integer seat) throws IOException;
    void cancelTicket(Long ticketId);
    List<TicketDTO> showTicketsByUserId(Long userId);
    List<TicketDTO> showTicketsByTicketStatus(String status);
}
