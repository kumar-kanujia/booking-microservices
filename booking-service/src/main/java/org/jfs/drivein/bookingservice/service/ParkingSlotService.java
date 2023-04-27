package org.jfs.drivein.bookingservice.service;

import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.exception.UnavailableTitleException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;

import java.util.List;

/*
author kumar-kanujia
 */

public interface ParkingSlotService {

	void createSlot(ParkingSlot parkingSlot);

	void updateSlot(ParkingSlot parkingSlot) throws UnavailableSlotException;

	void deleteSlot(ParkingSlot id) throws UnavailableSlotException;

	List<ParkingSlot> findParkingSlotByTitle(String title) throws UnavailableTitleException;

	List<ParkingSlot> findParkingSlotByTitleAndDate(String title, String date) throws UnavailableSlotException;

	List<ParkingSlot> findParkingSlotByDate(String date) throws UnavailableSlotException;

	ParkingSlot findParkingSlotByDateAndTime(String date, String time) throws UnavailableSlotException;

	ParkingSlot findParkingSlotById(String slotId) throws UnavailableSlotException;
}
