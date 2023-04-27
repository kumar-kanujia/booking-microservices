package org.jfs.drivein.bookingservice.service;

import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.Ticket;

/*
author kumar- 1.0.0
 */

public interface TicketService {

	void cancelTicket(String id);

	Ticket viewTicket(String id) throws TicketNotFoundException;

	Ticket bookTicket(String slotId, String carNumber, String section) throws UnavailableSlotException;
}
