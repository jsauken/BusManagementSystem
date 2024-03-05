package kz.iitu.intercitybustransportation.service.impl;

import kz.iitu.intercitybustransportation.dto.TicketDTO;
import kz.iitu.intercitybustransportation.exceptions.ResourceNotFoundException;
import kz.iitu.intercitybustransportation.mapper.TicketMapper;
import kz.iitu.intercitybustransportation.model.Ticket;
import kz.iitu.intercitybustransportation.repository.TicketRepository;
import kz.iitu.intercitybustransportation.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public TicketDTO getTicket(Long id) {
        return ticketRepository.findById(id)
                .map(ticketMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO createTicket(TicketDTO ticketDto) {
        Ticket ticket = ticketMapper.toEntity(ticketDto);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toDto(savedTicket);
    }

    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDto) {
        return ticketRepository.findById(id)
                .map(ticket -> {
                    // Update the fields of the ticket as per your requirements
                    Ticket updatedTicket = ticketRepository.save(ticket);
                    return ticketMapper.toDto(updatedTicket);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id " + id));
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.findById(id)
                .ifPresentOrElse(ticketRepository::delete, () -> {
                    throw new ResourceNotFoundException("Ticket not found with id " + id);
                });
    }
}
