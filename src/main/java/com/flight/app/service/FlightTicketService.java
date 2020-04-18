package com.flight.app.service;

import com.flight.app.entity.FlightTicket;

public interface FlightTicketService {
    FlightTicket findById(Long id);
    FlightTicket insert(FlightTicket entity);
}
