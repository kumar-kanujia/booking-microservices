package org.jfs.drivein.bookingservice.dao;

import java.util.Optional;

import org.jfs.drivein.bookingservice.model.ParkingSlot;

public interface ParkingSlotDao {

	Optional<ParkingSlot> viewSlotByTitle(String title);
	Optional<ParkingSlot> viewSlotByDate(String title);
	Optional<ParkingSlot> viewSlotByDateAndTime(String title);
}
