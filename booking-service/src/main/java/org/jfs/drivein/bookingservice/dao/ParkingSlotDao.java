package org.jfs.drivein.bookingservice.dao;

import org.jfs.drivein.bookingservice.model.ParkingSlot;

import java.util.List;
import java.util.Optional;

/*
author mujain
 */

public interface ParkingSlotDao {

	void saveParkingSlot(ParkingSlot parkingSlot);

	void deleteParkingSlot(ParkingSlot parkingSlot);

	List<ParkingSlot> findParkingSlotByTitle(String title);

	List<ParkingSlot> findParkingSlotByTitleAndDate(String title, String date);

	List<ParkingSlot> findParkingSlotByDate(String date);

	Optional<ParkingSlot> findParkingSlotByDateAndTime(String date, String time);

    Optional<ParkingSlot> findParkingSlotById(String slotId);
}
