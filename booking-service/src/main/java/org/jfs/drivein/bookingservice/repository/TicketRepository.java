package org.jfs.drivein.bookingservice.repository;

import org.jfs.drivein.bookingservice.model.Ticket;
import org.springframework.data.repository.CrudRepository;
/*
author kumar- 1.0.0
 */


public interface TicketRepository extends CrudRepository<Ticket, String> {
}
