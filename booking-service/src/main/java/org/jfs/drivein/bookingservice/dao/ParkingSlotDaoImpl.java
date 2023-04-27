package org.jfs.drivein.bookingservice.dao;

import java.util.Optional;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingSlotDaoImpl implements ParkingSlotDao{

	private SlotRepository slotRepository;
	
	@Autowired
	public ParkingSlotDaoImpl(SlotRepository slotRepository) {
		this.slotRepository = slotRepository;
	}

	@Override
	public Optional<ParkingSlot> viewSlotByTitle(String title) {
		return Optional.empty();
	}

	@Override
	public Optional<ParkingSlot> viewSlotByDate(String title) {
		return Optional.empty();
	}

	@Override
	public Optional<ParkingSlot> viewSlotByDateAndTime(String title) {
		return Optional.empty();
	}
}
