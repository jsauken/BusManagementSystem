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
        ticketDto.setUser(userMapper.toDto(ticket.getUser()));
        ticketDto.setFlight(flightMapper.toDto(ticket.getFlight()));
        ticketDto.setSeatNumber(ticket.getSeatNumber());
        ticketDto.setBookingTime(ticket.getBookingTime());
        ticketDto.setPrice(ticket.getPrice());
        ticketDto.setQrCode(ticket.getQrCode());
        return ticketDto;
    }

    public Ticket toEntity(TicketDTO ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setUser(userMapper.toEntity(ticketDto.getUser()));
        ticket.setFlight(flightMapper.toEntity(ticketDto.getFlight()));
        ticket.setSeatNumber(ticketDto.getSeatNumber());
        ticket.setBookingTime(ticketDto.getBookingTime());
        ticket.setPrice(ticketDto.getPrice());
        ticket.setQrCode(ticketDto.getQrCode());
        return ticket;
    }
}
