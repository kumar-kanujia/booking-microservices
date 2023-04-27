package org.jfs.drivein.bookingservice.dao;

import java.util.Optional;

import org.jfs.drivein.bookingservice.model.Ticket;
import org.jfs.drivein.bookingservice.repository.TicketRepository;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {

	private final TicketRepository ticketRepository;

	public TicketDaoImpl(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public void cancelTicket(String id) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(id);
	}

	@Override
	public Optional<Ticket> viewTicket(String id) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(id);
	}

}
