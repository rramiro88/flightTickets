package com.flight.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FlightTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itineraryId;

    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;

    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;

    private String
            cityOfOrigin,
            destinationCity,
            passengerName;
    private Boolean luggageStorage;
    private Float price;

}
