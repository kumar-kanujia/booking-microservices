package org.jfs.drivein.bookingservice.resource;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.exception.UnavailableTitleException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.model.Ticket;
import org.jfs.drivein.bookingservice.service.ParkingSlotService;
import org.jfs.drivein.bookingservice.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/*
author kumar- 1.0.0
 */

@RestController
@AllArgsConstructor
public class BookingResource {

    private final ParkingSlotService parkingSlotService;

    private final TicketService ticketService;


    @GetMapping(value="view", params = "title")
    public List<ParkingSlot> viewByTitle(@RequestParam String title) throws UnavailableTitleException {
        return parkingSlotService.findParkingSlotByTitle(title);
    }

    @GetMapping(value="view", params = {"title", "date"})
    public List<ParkingSlot> viewByTitleAndDate(@RequestParam String title, @RequestParam String date) throws UnavailableSlotException {
        return parkingSlotService.findParkingSlotByTitleAndDate(title, date);
    }

    @GetMapping(value="view", params = {"date", "time"})
    public ParkingSlot viewByDateAndTime(@RequestParam String date, @RequestParam String time) throws UnavailableSlotException {
        return parkingSlotService.findParkingSlotByDateAndTime(date, time);
    }
    @GetMapping(value="view", params = "date")
    public List<ParkingSlot> viewByDate(@RequestParam String date) throws UnavailableSlotException {
        return parkingSlotService.findParkingSlotByDate(date);
    }

    @PostMapping("book/{slotId}/{section}/{carNumber}")
    public ResponseEntity<Ticket> bookTicket(@PathVariable String slotId, @PathVariable String section, @PathVariable String carNumber, HttpServletRequest servletRequest) throws UnavailableSlotException{
        Ticket ticket = ticketService.bookTicket(slotId, carNumber, section);
        URI uri = ServletUriComponentsBuilder.fromContextPath(servletRequest).path("view/ticket/{ticketId}").buildAndExpand(ticket.getId()).toUri();
        return ResponseEntity.created(uri).body(ticket);
    }

}
