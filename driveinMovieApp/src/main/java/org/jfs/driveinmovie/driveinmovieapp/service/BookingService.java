package org.jfs.driveinmovie.driveinmovieapp.service;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.model.ParkingSlot;
import org.jfs.driveinmovie.driveinmovieapp.model.Ticket;
import org.jfs.driveinmovie.driveinmovieapp.resource.BookingResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingResource bookingResource;

    public Ticket getTicket(String id) {
        return bookingResource.viewTicket(id).getBody();
    }

    public ParkingSlot getSlot(String slotId) {
        return bookingResource.findParkingSlot(slotId).get(0);
    }

    public Ticket bookTicket(String slotId, Ticket ticket) {
        return bookingResource.bookTicket(slotId, ticket.getTier(), ticket.getCarNumber()).getBody();
    }

    public List<ParkingSlot> getParkingSlotByTitle(String title) {
    return bookingResource.findByTitle(title);
    }

    public List<ParkingSlot> getParkingSlotByTitleAndDate(String title, String date) {
        return bookingResource.findByTitleAndDate(title, date);
    }

    public void cancelTicket(String id) {
        bookingResource.cancelTicket(id);
    }
}
