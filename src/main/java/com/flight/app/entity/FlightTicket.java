package com.flight.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Date departureDate;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date arrivalDate;

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date departureTime;

    @Temporal(TemporalType.TIME)
    @NotNull
    private Date arrivalTime;

    @NotNull
    private String cityOfOrigin;

    @NotNull
    private String destinationCity;

    @NotNull
    private String passengerName;

    @NotNull
    private Boolean luggageStorage;

    @NotNull
    private Float price;

}
