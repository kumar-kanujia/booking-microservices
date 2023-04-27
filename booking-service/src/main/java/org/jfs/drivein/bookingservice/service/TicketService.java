package org.jfs.drivein.bookingservice.service;

import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.Ticket;

/*
author kumar-kanujia
 */

public interface TicketService {

	void cancelTicket(String id) throws TicketNotFoundException;

	Ticket viewTicket(String id) throws TicketNotFoundException;

	Ticket bookTicket(String slotId, String carNumber, String tier) throws UnavailableSlotException;
}
