package com.flight.app.endpoint;

import com.flight.app.converter.FlightTicketConverter;
import com.flight.app.dto.FlightTicketDto;
import com.flight.app.entity.FlightTicket;
import com.flight.app.service.FlightTicketService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
@AllArgsConstructor
public class FlightTicketEndpoint {

    @Autowired
    private FlightTicketService service;

    @Autowired
    private FlightTicketConverter converter;

    @GetMapping(value = "/{id}")
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
    public ResponseEntity createTicket(@RequestBody FlightTicketDto dto){

        try {

            return ResponseEntity.ok(service.insert(converter.toEntity(dto)));

        }catch (Exception e){
            return new ResponseEntity<>("The entity couldn't be created", HttpStatus.CONFLICT);
        }


    }

}
