package org.jfs.drivein.bookingservice.service;

import org.jfs.drivein.bookingservice.model.Ticket;

public interface TicketService {

	Ticket bookTicket(Ticket ticket);

	Ticket updateTicket(Ticket ticket);

	void cancelTicket(Ticket ticket);

	Ticket viewTicket(Ticket ticket);
}
