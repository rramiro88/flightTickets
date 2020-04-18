package com.flight.app.service;

import com.flight.app.entity.FlightTicket;
import com.flight.app.repository.FlightTicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FlightTicketServiceImplTest {

    @Test
    void insert() {

        FlightTicketRepository repository = mock(FlightTicketRepository.class);
        when(repository.save(any())).thenReturn(FlightTicket.builder().itineraryId(1L).build());

        FlightTicketService service = new FlightTicketServiceImpl(repository);

        FlightTicket response = service.insert(FlightTicket.builder().passengerName("testInput").build());
        assertNotNull(response);
        assertNotNull(response.getItineraryId());
    }

    @Test
    void findById() {

        FlightTicketRepository repository = mock(FlightTicketRepository.class);
        when(repository.findById(any())).thenReturn(Optional.of(FlightTicket.builder().itineraryId(1L).build()));

        FlightTicketService service = new FlightTicketServiceImpl(repository);

        FlightTicket response = service.findById(1L);
        assertNotNull(response);
        assertNotNull(response.getItineraryId());
    }
}