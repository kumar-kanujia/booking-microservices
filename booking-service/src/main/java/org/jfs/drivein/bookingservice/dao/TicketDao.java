package org.jfs.drivein.bookingservice.dao;

import org.jfs.drivein.bookingservice.model.Ticket;

import java.util.Optional;

/*
author kumar- 1.0.0
 */

public interface TicketDao {

	Ticket saveTicket(Ticket ticket);

	void cancelTicket(String id);

	Optional<Ticket> viewTicket(String id);
}
