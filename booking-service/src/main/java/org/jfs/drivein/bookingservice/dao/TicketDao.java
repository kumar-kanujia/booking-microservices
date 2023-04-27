package org.jfs.drivein.bookingservice.dao;

import org.jfs.drivein.bookingservice.model.Ticket;

import java.util.Optional;

/*
author kumar-kanujia
 */
public interface TicketDao {

	Ticket saveTicket(Ticket ticket);

	void cancelTicket(String id);

	Optional<Ticket> viewTicket(String id);
}
