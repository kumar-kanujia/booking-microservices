package org.jfs.drivein.bookingservice.dao;

import lombok.AllArgsConstructor;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.repository.ParkingSlotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
author kumar-kanujia mujain
 */
@Repository
@AllArgsConstructor
public class ParkingSlotDaoImpl implements ParkingSlotDao {

	private final ParkingSlotRepository slotRepository;

	@Override
	public void saveParkingSlot(ParkingSlot parkingSlot) {
		slotRepository.save(parkingSlot);
	}

	@Override
	public void deleteParkingSlot(ParkingSlot parkingSlot) {
		slotRepository.delete(parkingSlot);
	}

	@Override
	public List<ParkingSlot> findParkingSlotByTitle(String title) {
		return slotRepository.findByTitle(title);
	}

	@Override
	public List<ParkingSlot> findParkingSlotByTitleAndDate(String title, String date) {
		return slotRepository.findByTitleAndDate(title, date);
	}

	@Override
	public List<ParkingSlot> findParkingSlotByDate(String date) {
		return slotRepository.findByDate(date);
	}

	@Override
	public Optional<ParkingSlot> findParkingSlotByDateAndTime(String date, String time) {
		return slotRepository.findByDateAndDate(date, time);
	}

	@Override
	public Optional<ParkingSlot> findParkingSlotById(String slotId) {
		return slotRepository.findById(slotId);
	}
}