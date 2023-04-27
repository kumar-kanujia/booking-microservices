package org.jfs.drivein.bookingservice.resource;

import lombok.AllArgsConstructor;
import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.model.Ticket;
import org.jfs.drivein.bookingservice.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
author kumar- 1.0.0
 */
@RestController
@AllArgsConstructor
public class TicketResource {

    private final TicketService ticketService;

    @GetMapping("view/ticket/{ticketId}")
    public ResponseEntity<Ticket> viewTicket(@PathVariable String ticketId) throws TicketNotFoundException {
        return ResponseEntity.ok(ticketService.viewTicket(ticketId));
    }

    @DeleteMapping("cancel/ticket/{ticketId}")
    public ResponseEntity<?> cancelTicket(@PathVariable String ticketId) throws TicketNotFoundException{
        ticketService.cancelTicket(ticketId);
        return ResponseEntity.noContent().build();
    }
}
