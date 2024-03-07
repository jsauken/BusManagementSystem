package kz.iitu.intercitybustransportation.repository;

import kz.iitu.intercitybustransportation.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight getByArrivalTime(LocalDateTime time);
    Flight getById(Long id);

}