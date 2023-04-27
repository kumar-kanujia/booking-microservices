package org.jfs.drivein.bookingservice.service;

import java.util.Optional;

import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.model.Ticket;

public interface TicketService {

	Ticket bookTicket(Ticket ticket);

	void cancelTicket(String id);

	Optional<Ticket> viewTicket(String id) throws TicketNotFoundException;
}
