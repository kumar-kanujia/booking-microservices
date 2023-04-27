package org.jfs.drivein.bookingservice.repository;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*
author kumar- 1.0.0
 */
public interface ParkingSlotRepository extends CrudRepository<ParkingSlot, String>{

	List<ParkingSlot> findByTitle(String title);

	List<ParkingSlot> findByTitleAndDate(String title, String date);

	List<ParkingSlot> findByDate(String date);

	Optional<ParkingSlot> findByDateAndDate(String date, String time);
}
