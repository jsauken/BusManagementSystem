package kz.iitu.intercitybustransportation.mapper;

import kz.iitu.intercitybustransportation.dto.TicketDTO;
import kz.iitu.intercitybustransportation.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TicketMapper {

    private final UserMapper userMapper;
    private final FlightMapper flightMapper;

    @Autowired
    public TicketMapper(UserMapper userMapper, FlightMapper flightMapper) {
        this.userMapper = userMapper;
        this.flightMapper = flightMapper;
    }

    public TicketDTO toDto(Ticket ticket) {
        TicketDTO ticketDto = new TicketDTO();
        ticketDto.setId(ticket.getId());
        ticketDto.setFlightId(ticket.getFlight().getId());
        ticketDto.setUserId(ticket.getUser().getId());
        ticketDto.setSeatNumber(ticket.getSeatNumber());
        return ticketDto;
    }

    public Ticket toEntity(TicketDTO ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setSeatNumber(ticketDto.getSeatNumber());
        return ticket;
    }
}
