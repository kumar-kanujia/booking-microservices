package org.jfs.drivein.bookingservice.service;

import java.util.Optional;

import org.jfs.drivein.bookingservice.dao.TicketDao;
import org.jfs.drivein.bookingservice.exception.TicketNotFoundException;
import org.jfs.drivein.bookingservice.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketDao ticketDao;

	@Override
	public Ticket bookTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelTicket(String id) {
		// TODO Auto-generated method stub
		ticketDao.cancelTicket(id);
	}

	@Override
	public Optional<Ticket> viewTicket(String id) throws TicketNotFoundException{
		// TODO Auto-generated method stub
		
		Optional<Ticket> ticket =  ticketDao.viewTicket(id);
		if(ticket.isEmpty()) {
			throw new TicketNotFoundException("");
		}
		return ticket;
	}

}
