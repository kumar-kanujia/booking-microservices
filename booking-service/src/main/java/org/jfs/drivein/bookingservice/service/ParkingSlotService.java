package org.jfs.drivein.bookingservice.service;

import java.util.List;

import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.exception.UnavailableTitleException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;

/*
author kumar-kanujia
 */

public interface ParkingSlotService {


	List<ParkingSlot> findParkingSlotByTitle(String title) throws UnavailableTitleException;

	List<ParkingSlot> findParkingSlotByTitleAndDate(String title, String date) throws UnavailableSlotException;

	List<ParkingSlot> findParkingSlotByDate(String date) throws UnavailableSlotException;

	ParkingSlot findParkingSlotByDateAndTime(String date, String time) throws UnavailableSlotException;

	ParkingSlot findParkingSlotById(String slotId) throws UnavailableSlotException;

	void createSlot(String title, String date, String slotTime);

	void updateSlot(String title, String date, String slotTime) throws UnavailableSlotException;

	void deleteSlot(String date, String slotTime) throws UnavailableSlotException;
}
