package org.jfs.drivein.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.jfs.drivein.bookingservice.dao.ParkingSlotDao;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.exception.UnavailableTitleException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

/*
author kumar-kanujia
 */

@Service
@AllArgsConstructor
public class ParkingSlotServiceImpl implements ParkingSlotService {
	
	private final ParkingSlotDao parkingSlotDao;

	@Override
	public ParkingSlot saveSlot(ParkingSlot parkingSlot) {
		return parkingSlotDao.saveParkingSlot(parkingSlot);
	}

	@Override
	public void deleteSlot(String id) throws UnavailableSlotException {
		ParkingSlot slot = findParkingSlotById(id).get(0);
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
	public List<ParkingSlot> findParkingSlotById(String slotId) throws UnavailableSlotException {
		List<ParkingSlot> parkingSlot = parkingSlotDao.findParkingSlotById(slotId);
		if (parkingSlot.size()==0) throw new UnavailableSlotException("");
		return parkingSlot;
	}



	@Override
	public void updateSlot(String id, String title) throws UnavailableSlotException {
		ParkingSlot slot = findParkingSlotById(id).get(0);
		slot.setTitle(title);
		parkingSlotDao.saveParkingSlot(slot);
	}

}
