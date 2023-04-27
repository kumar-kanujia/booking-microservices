package org.jfs.drivein.bookingservice.repository;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.data.repository.CrudRepository;

public interface SlotRepository extends CrudRepository<ParkingSlot, String>{

}
