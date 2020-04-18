package com.flight.app;


import com.flight.app.converter.FlightTicketConverter;
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
import java.util.Date;
import java.util.Objects;


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
		endpoint.createTicket(converter.toDto(ticket));

		ResponseEntity responseEntity = endpoint.findTicket(ticket.getItineraryId());

		Assert.assertEquals(200, responseEntity.getStatusCodeValue());
		Assert.assertEquals("testCity2", ((FlightTicket) Objects.requireNonNull(responseEntity.getBody())).getCityOfOrigin());

	}

	private FlightTicket generateTicket(){
		return FlightTicket.builder()
				.itineraryId(1L)
				.passengerName("testName")
				.price(250.5F)
				.luggageStorage(true)
				.destinationCity("testCity1")
				.cityOfOrigin("testCity2")
				.departureTime("15:30")
				.arrivalTime("19:45")
				.departureDate(new Date())
				.arrivalDate(new Date())
				.build();
	}

}
