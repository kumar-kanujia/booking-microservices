package org.jfs.drivein.bookingservice.service;

import lombok.AllArgsConstructor;
import org.jfs.drivein.bookingservice.dao.ParkingSlotDao;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.exception.UnavailableTitleException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
author kumar-kanujia
 */

@Service
@AllArgsConstructor
public class ParkingSlotServiceImpl implements ParkingSlotService {
	
	private final ParkingSlotDao parkingSlotDao;


	@Override
	public void createSlot(ParkingSlot parkingSlot) {
		parkingSlotDao.saveParkingSlot(new ParkingSlot(parkingSlot.getTitle(),parkingSlot.getDate(), parkingSlot.getSlotTime(), 20,20,20));
	}

	@Override
	public void updateSlot(ParkingSlot parkingSlot) throws UnavailableSlotException {
		ParkingSlot slot = findParkingSlotByDateAndTime(parkingSlot.getDate(), parkingSlot.getSlotTime());
		slot.setTitle(parkingSlot.getTitle());
		parkingSlotDao.saveParkingSlot(slot);
	}

	@Override
	public void deleteSlot(ParkingSlot parkingSlot) throws UnavailableSlotException {
		ParkingSlot slot = findParkingSlotByDateAndTime(parkingSlot.getDate(), parkingSlot.getSlotTime());
		parkingSlotDao.deleteParkingSlot(slot);
	}

	@Override
	public List<ParkingSlot> findParkingSlotByTitle(String title) throws UnavailableTitleException {
		List<ParkingSlot> parkingSlots = parkingSlotDao.findParkingSlotByTitle(title);
		if (parkingSlots.isEmpty()) throw  new UnavailableTitleException("");
		return parkingSlots;
	}

	@Override
	public List<ParkingSlot> findParkingSlotByTitleAndDate(String title, String date) throws UnavailableSlotException {
		List<ParkingSlot> parkingSlots = parkingSlotDao.findParkingSlotByTitleAndDate(title, date);
		if (parkingSlots.isEmpty()) throw new UnavailableSlotException("");
		return parkingSlots;
	}

	@Override
	public List<ParkingSlot> findParkingSlotByDate(String date) throws UnavailableSlotException {
		List<ParkingSlot> parkingSlots = parkingSlotDao.findParkingSlotByDate(date);
		if (parkingSlots.isEmpty()) throw new UnavailableSlotException("");
		return parkingSlots;
	}

	@Override
	public ParkingSlot findParkingSlotByDateAndTime(String date, String time) throws UnavailableSlotException {
		Optional<ParkingSlot> optionalParkingSlot = parkingSlotDao.findParkingSlotByDateAndTime(date, time);
		if (optionalParkingSlot.isEmpty()) throw new UnavailableSlotException("");
		return optionalParkingSlot.get();
	}

	@Override
	public ParkingSlot findParkingSlotById(String slotId) throws UnavailableSlotException {
		Optional<ParkingSlot> optionalParkingSlot = parkingSlotDao.findParkingSlotById(slotId);
		if (optionalParkingSlot.isEmpty()) throw new UnavailableSlotException("");
		return optionalParkingSlot.get();
	}
}
