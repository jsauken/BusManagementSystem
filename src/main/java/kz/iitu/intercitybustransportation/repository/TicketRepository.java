package kz.iitu.intercitybustransportation.repository;

import kz.iitu.intercitybustransportation.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}