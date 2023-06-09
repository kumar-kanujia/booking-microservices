package org.jfs.drivein.bookingservice.service;

import java.util.Optional;

import org.jfs.drivein.bookingservice.client.ScheduleClient;
import org.jfs.drivein.bookingservice.dao.TicketDao;
import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.model.Ticket;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/*
author kumar-kanujia
 */

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

	private final TicketDao ticketDao;

	private final ParkingSlotService parkingSlotService;

	private final ScheduleClient scheduleClient;

	@Override
	public void cancelTicket(String id) throws TicketNotFoundException, UnavailableSlotException {
		Ticket ticket = ticketDao.viewTicket(id).orElseThrow(() -> new TicketNotFoundException(""));
		ticketDao.cancelTicket(id);
		ParkingSlot slot = parkingSlotService.findParkingSlotByDateAndTime(ticket.getDate(), ticket.getSlotTime());
		if (ticket.getTier().equals("a")){
			slot.setTier1(slot.getTier1()+1);
		} else if (ticket.getTier().equals("b")) {
			slot.setTier2(slot.getTier1()+1);
		}else {
			slot.setTier3(slot.getTier3()+1);
		}
		parkingSlotService.saveSlot(slot);
	}

	@Override
	public Ticket viewTicket(String id) throws TicketNotFoundException {
		Optional<Ticket> optionalTicket = ticketDao.viewTicket(id);
		if (optionalTicket.isEmpty()) throw  new TicketNotFoundException("");
		return optionalTicket.get();
	}

	@Override
	public Ticket bookTicket(String slotId, String carNumber, String tier) throws UnavailableSlotException {
		ParkingSlot parkingSlot = parkingSlotService.findParkingSlotById(slotId).get(0);
		Ticket ticket = new Ticket();
		ticket.setSlotTime(parkingSlot.getSlotTime());
		if (tier.equals("a") && parkingSlot.getTier1()>0){
			ticket.setPrice(scheduleClient.getPrice(parkingSlot.getDate(), tier, ticket.getSlotTime()));
			ticket.setSeatNo(parkingSlot.getTier1());
			parkingSlot.setTier1(parkingSlot.getTier1()-1);
		} else if (tier.equals("b") && parkingSlot.getTier2()>0) {
			ticket.setPrice(scheduleClient.getPrice(parkingSlot.getDate(), tier, ticket.getSlotTime()));
			ticket.setSeatNo(parkingSlot.getTier2());
			parkingSlot.setTier2(parkingSlot.getTier2()-1);
		}else if (tier.equals("c") && parkingSlot.getTier3()>0) {
			ticket.setPrice(scheduleClient.getPrice(parkingSlot.getDate(), tier, ticket.getSlotTime()));
			ticket.setSeatNo(parkingSlot.getTier3());
			parkingSlot.setTier3(parkingSlot.getTier3()-1);
		}else{
			throw new UnavailableSlotException("");
		}
		ticket.setCarNumber(carNumber);
		ticket.setTitle(parkingSlot.getTitle());
		ticket.setDate(parkingSlot.getDate());
		ticket.setTier(tier);
		parkingSlotService.saveSlot(parkingSlot);
		return ticketDao.saveTicket(ticket);
	}
}
