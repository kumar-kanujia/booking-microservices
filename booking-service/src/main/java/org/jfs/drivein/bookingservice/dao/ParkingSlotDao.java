package org.jfs.drivein.bookingservice.dao;

import java.util.List;
import java.util.Optional;

import org.jfs.drivein.bookingservice.model.ParkingSlot;

public interface ParkingSlotDao {

	ParkingSlot saveParkingSlot(ParkingSlot parkingSlot);

	void deleteParkingSlot(String id);

	List<ParkingSlot> findParkingSlot(String title);

	Optional<ParkingSlot> findParkingSlot(String title, String date);
}
