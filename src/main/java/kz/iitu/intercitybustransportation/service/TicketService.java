package kz.iitu.intercitybustransportation.service;

import kz.iitu.intercitybustransportation.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO getTicket(Long id);
    List<TicketDTO> getAllTickets();
    TicketDTO createTicket(TicketDTO ticketDto);
    TicketDTO updateTicket(Long id, TicketDTO ticketDto);
    void deleteTicket(Long id);
}
