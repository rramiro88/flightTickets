package com.flight.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightTicketDto {

    private Long itineraryId;

    private LocalDate departureDate;

    private LocalDate arrivalDate;

    private LocalTime departureTime;

    private LocalTime arrivalTime;

    private String
            cityOfOrigin,
            destinationCity,
            passengerName;
    private Boolean luggageStorage;
    private Float price;
    private Integer passengerAge;
}
