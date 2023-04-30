package org.jfs.driveinmovie.driveinmovieapp.service;

import org.jfs.driveinmovie.driveinmovieapp.model.ParkingSlot;
import org.jfs.driveinmovie.driveinmovieapp.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    public Ticket getTicket(String id) {
        return new Ticket(id,"832y84", "u49901","ejwfbkw", "ejkkfb","feafwe",23,378 );
    }

    public ParkingSlot getSlot(String slotId) {
        return new ParkingSlot(slotId, "Avenger", "2020-12-10", "09:00 AM", 20, 20, 20);
    }

    public Ticket bookTicket(Ticket ticket) {
        return new Ticket("13", "avengers", "2020-12-12", "622 pm", ticket.getCarNumber(), ticket.getTier(), 30, 729);
    }

    public List<ParkingSlot> getParkingSlotByTitle(String title) {
        return List.of(new ParkingSlot("hdhs", title, "2020-12-10", "09:00 AM", 20, 20, 20));
    }

    public List<ParkingSlot> getParkingSlotByTitleAndDate(String title, String date) {
        return List.of(new ParkingSlot("hdhs", title + "tile", "2023-12-10", "09:00 AM", 20, 20, 20));
    }
}
