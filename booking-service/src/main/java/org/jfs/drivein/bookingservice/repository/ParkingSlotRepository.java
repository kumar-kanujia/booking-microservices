package org.jfs.drivein.bookingservice.repository;

import java.util.List;
import java.util.Optional;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.data.repository.CrudRepository;

/*
author kumar-kanujia
 */
public interface ParkingSlotRepository extends CrudRepository<ParkingSlot, String>{

	List<ParkingSlot> findByTitle(String title);

	List<ParkingSlot> findByTitleAndDate(String title, String date);

	List<ParkingSlot> findByDate(String date);

	Optional<ParkingSlot> findByDateAndSlotTime(String date, String slotTime);
}
