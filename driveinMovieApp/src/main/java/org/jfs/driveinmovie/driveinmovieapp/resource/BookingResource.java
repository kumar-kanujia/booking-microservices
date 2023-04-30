package org.jfs.driveinmovie.driveinmovieapp.resource;

import org.jfs.driveinmovie.driveinmovieapp.model.ParkingSlot;
import org.jfs.driveinmovie.driveinmovieapp.model.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "Booking-service", url = "http://localhost:8020/")
public interface BookingResource {


    @GetMapping(value = "view", params = "title")
    List<ParkingSlot>  findByTitle(@RequestParam String title);

    @GetMapping(value = "view", params = {"title, date"})
    List<ParkingSlot> findByTitleAndDate(@RequestParam String title, @RequestParam String Date);

    @PostMapping("book/{slotId}/{section}/{carNumber}")
    ResponseEntity<Ticket> bookTicket(@PathVariable String slotId, @PathVariable String section, @PathVariable String carNumber);

    @GetMapping("slot/{slotId}")
    List<ParkingSlot> findParkingSlot(@PathVariable String slotId);

    @DeleteMapping("cancel/ticket/{ticketId}")
    void cancelTicket(@PathVariable String ticketId);

    @GetMapping("view/ticket/{ticketId}")
    ResponseEntity<Ticket> viewTicket(@PathVariable String ticketId);
}
