package com.flight.app.repository;

import com.flight.app.entity.FlightTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface FlightTicketRepository extends CrudRepository<FlightTicket,Long> {
}
