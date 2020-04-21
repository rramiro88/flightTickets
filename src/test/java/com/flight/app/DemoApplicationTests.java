package com.flight.app;


import com.flight.app.converter.FlightTicketConverter;
import com.flight.app.dto.FlightTicketDto;
import com.flight.app.endpoint.FlightTicketEndpoint;
import com.flight.app.entity.FlightTicket;
import com.flight.app.service.FlightTicketService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalTime;


@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class DemoApplicationTests {

	@Autowired
	private FlightTicketService service;

	@Autowired
	private FlightTicketConverter converter;

	@Test
	void endpointTest(){

		FlightTicketEndpoint endpoint = new FlightTicketEndpoint(service,converter);
		FlightTicket ticket = generateTicket();
		FlightTicketDto dto = converter.toDto(ticket);
		endpoint.createTicket(dto);

		ResponseEntity response = endpoint.findTicket(ticket.getItineraryId());
		FlightTicket responseEntity = (FlightTicket) response.getBody();

		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(responseEntity,ticket);

	}

	private FlightTicket generateTicket(){
		return FlightTicket.builder()
				.itineraryId(1L)
				.passengerName("testName")
				.price(250.5F)
				.luggageStorage(true)
				.destinationCity("testCity1")
				.cityOfOrigin("testCity2")
				.departureTime(LocalTime.of(20,15))
				.arrivalTime(LocalTime.of(21,40))
				.departureDate(LocalDate.of(2020, 3,10))
				.arrivalDate(LocalDate.of(2020,3,11))
				.passengerAge(40)
				.build();
	}

}
