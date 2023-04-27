package org.jfs.drivein.bookingservice.dao;

import java.util.Optional;

import org.jfs.drivein.bookingservice.model.Ticket;

public interface TicketDao {

	Ticket saveTicket(Ticket ticket);

	void cancelTicket(String id);

	Optional<Ticket> viewTicket(String id);
}
