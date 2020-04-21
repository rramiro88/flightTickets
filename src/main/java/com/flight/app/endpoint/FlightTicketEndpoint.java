package com.flight.app.endpoint;

import com.flight.app.converter.FlightTicketConverter;
import com.flight.app.dto.FlightTicketDto;
import com.flight.app.entity.FlightTicket;
import com.flight.app.service.FlightTicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
@Api(
        tags = "FlightTicketsApi",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class FlightTicketEndpoint {

    private final FlightTicketService service;

    private final FlightTicketConverter converter;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Finds a ticket", nickname = "findTicket")
    public ResponseEntity findTicket(@PathVariable("id") Long id){

        try{

            FlightTicket entity = service.findById(id);
            if(entity!=null){
                return ResponseEntity.ok(entity);
            }

            return ResponseEntity.noContent().build();

        }catch(Exception e){
            return new ResponseEntity<>("An error has occurred",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    @ApiOperation(value = "Creates a new ticket", nickname = "saveTicket")
    public ResponseEntity createTicket(@RequestBody FlightTicketDto dto){

        try {
            FlightTicket flightTicket = service.insert(converter.toEntity(dto));
            dto.setItineraryId(flightTicket.getItineraryId());
            return ResponseEntity.ok(converter.toDto(flightTicket));

        }catch (Exception e){
            return new ResponseEntity<>("The entity couldn't be created. Please check all fields, they're all required ", HttpStatus.CONFLICT);
        }


    }

}
