package org.jfs.drivein.bookingservice.service;

import lombok.AllArgsConstructor;
import org.jfs.drivein.bookingservice.dao.TicketDao;
import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.model.Ticket;
import org.jfs.drivein.bookingservice.proxy.ScheduleProxy;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*
author kumar- 1.0.0
 */

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {
	
	private final TicketDao ticketDao;

	private final ParkingSlotService parkingSlotService;

	private final ScheduleProxy scheduleProxy;

	@Override
	public void cancelTicket(String id) {
		ticketDao.cancelTicket(id);
	}

	@Override
	public Ticket viewTicket(String id) throws TicketNotFoundException {
		Optional<Ticket> optionalTicket = ticketDao.viewTicket(id);
		if (optionalTicket.isEmpty()) throw  new TicketNotFoundException("");
		return optionalTicket.get();
	}

	@Override
	public Ticket bookTicket(String slotId, String carNumber, String section) throws UnavailableSlotException {
		ParkingSlot parkingSlot = parkingSlotService.findParkingSlotById(slotId);
		Ticket ticket = new Ticket();
		ticket.setCarNumber(carNumber);
		switch(section){
			case "frontSection":
				if (parkingSlot.getFrontSection() >0){
					ticket.setParkingSection(section);
					ticket.setPrice(scheduleProxy.getPrice(section));
					parkingSlot.setFrontSection(parkingSlot.getFrontSection()-1);

				}
		}
		return null;
	}
}
