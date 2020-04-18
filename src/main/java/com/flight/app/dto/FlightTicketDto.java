package com.flight.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightTicketDto {

    private Long itineraryId;
    private Date departureDate;
    private Date arrivalDate;

    private String departureTime;

    private String arrivalTime;

    private String
            cityOfOrigin,
            destinationCity,
            passengerName;
    private Boolean luggageStorage;
    private Float price;
    private Integer passengerAge;
}
