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
	public void cancelTicket(String id) throws TicketNotFoundException {
		ticketDao.viewTicket(id).orElseThrow(() -> new TicketNotFoundException(""));
		ticketDao.cancelTicket(id);
	}

	@Override
	public Ticket viewTicket(String id) throws TicketNotFoundException {
		Optional<Ticket> optionalTicket = ticketDao.viewTicket(id);
		if (optionalTicket.isEmpty()) throw  new TicketNotFoundException("");
		return optionalTicket.get();
	}

	@Override
	public Ticket bookTicket(String slotId, String carNumber, String tier) throws UnavailableSlotException {
		ParkingSlot parkingSlot = parkingSlotService.findParkingSlotById(slotId);
		Ticket ticket = new Ticket();
		if (tier.equals("a") && parkingSlot.getTier1()>0){
			ticket.setPrice(scheduleProxy.getPrice(parkingSlot.getId(), tier));
			ticket.setSeatNo(parkingSlot.getTier1());
			parkingSlot.setTier1(parkingSlot.getTier1()-1);
		} else if (tier.equals("b") && parkingSlot.getTier2()>0) {
			ticket.setPrice(scheduleProxy.getPrice(parkingSlot.getId(), tier));
			ticket.setSeatNo(parkingSlot.getTier2());
			parkingSlot.setTier2(parkingSlot.getTier2()-1);
		}else if (tier.equals("c") && parkingSlot.getTier3()>0) {
			ticket.setPrice(scheduleProxy.getPrice(parkingSlot.getId(), tier));
			ticket.setSeatNo(parkingSlot.getTier3());
			parkingSlot.setTier3(parkingSlot.getTier3()-1);
		}else{
			throw new UnavailableSlotException("");
		}
		ticket.setCarNumber(carNumber);
		ticket.setTitle(parkingSlot.getTitle());
		ticket.setDate(parkingSlot.getDate());
		ticket.setSlotTime(parkingSlot.getSlotTime());
		ticket.setTier(tier);
		return ticketDao.saveTicket(ticket);
	}
}
