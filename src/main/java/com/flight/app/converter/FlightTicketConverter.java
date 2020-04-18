package com.flight.app.converter;

import com.flight.app.dto.FlightTicketDto;
import com.flight.app.entity.FlightTicket;
import org.springframework.stereotype.Service;

@Service
public class FlightTicketConverter {
    
    public FlightTicket toEntity(FlightTicketDto dto){
        return FlightTicket.builder()
                .arrivalDate(dto.getArrivalDate())
                .arrivalTime(dto.getArrivalTime())
                .cityOfOrigin(dto.getCityOfOrigin())
                .departureDate(dto.getDepartureDate())
                .departureTime(dto.getDepartureTime())
                .destinationCity(dto.getDestinationCity())
                .itineraryId(dto.getItineraryId())
                .luggageStorage(dto.getLuggageStorage())
                .passengerName(dto.getPassengerName())
                .price(dto.getPrice())
                .build();
    }
    
    public FlightTicketDto toDto(FlightTicket entity){
        return FlightTicketDto.builder()
                .arrivalDate(entity.getArrivalDate())
                .arrivalTime(entity.getArrivalTime())
                .cityOfOrigin(entity.getCityOfOrigin())
                .departureDate(entity.getDepartureDate())
                .departureTime(entity.getDepartureTime())
                .destinationCity(entity.getDestinationCity())
                .itineraryId(entity.getItineraryId())
                .luggageStorage(entity.getLuggageStorage())
                .passengerName(entity.getPassengerName())
                .price(entity.getPrice())
                .build();
    }
    
}
