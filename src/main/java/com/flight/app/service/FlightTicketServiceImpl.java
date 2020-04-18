package com.flight.app.service;

import com.flight.app.entity.FlightTicket;
import com.flight.app.repository.FlightTicketRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class FlightTicketServiceImpl implements FlightTicketService{

    @Autowired
    private FlightTicketRepository repository;

    @Override
    public FlightTicket findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public FlightTicket insert(FlightTicket entity) {
        return repository.save(entity);
    }
}
