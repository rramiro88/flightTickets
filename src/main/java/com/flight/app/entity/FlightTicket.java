package com.flight.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class FlightTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itineraryId;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalDate;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime departureTime;

    @NotNull
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime arrivalTime;

    @NotNull
    private String cityOfOrigin;

    @NotNull
    private String destinationCity;

    @NotNull
    private String passengerName;

    @NotNull
    private Integer passengerAge;

    @NotNull
    private Boolean luggageStorage;

    @NotNull
    private Float price;

}
