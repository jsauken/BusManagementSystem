package kz.iitu.intercitybustransportation.controller;

import kz.iitu.intercitybustransportation.dto.FlightDTO;
import kz.iitu.intercitybustransportation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public FlightDTO getFlight(@PathVariable Long id) {
        return flightService.getFlight(id);
    }

    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAllFlights();
    }

    @PostMapping
    public FlightDTO createFlight(@RequestBody FlightDTO flightDto) {
        return flightService.createFlight(flightDto);
    }

    @PutMapping("/{id}")
    public FlightDTO updateFlight(@PathVariable Long id, @RequestBody FlightDTO flightDto) {
        return flightService.updateFlight(id, flightDto);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }
}
