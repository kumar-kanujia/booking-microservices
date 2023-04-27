package org.jfs.drivein.bookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.data.repository.CrudRepository;

public interface ParkingSlotRepository extends CrudRepository<ParkingSlot, String>{

	List<ParkingSlot> findByTitle(String title);

	Optional<ParkingSlot> findByTitleAndDate(String title, String date);

}
