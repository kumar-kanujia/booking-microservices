package org.jfs.drivein.bookingservice.service;

import java.util.List;

import org.jfs.drivein.bookingservice.NoSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;

public interface ParkingSlotService {

	ParkingSlot createSlot(String title, String date, String slotTime);

	ParkingSlot updateSlot(ParkingSlot parkingSlot);

	void deleteSlot(String id);

	List<ParkingSlot> findParkingSlotByTitle(String title) throws NoSlotException;

	ParkingSlot findParkingSlotByTitleAndDate(String title, String date) throws NoSlotException;

}
