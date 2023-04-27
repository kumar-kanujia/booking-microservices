package org.jfs.drivein.bookingservice.repository;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<ParkingSlot , String>{

}
