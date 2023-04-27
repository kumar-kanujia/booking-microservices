package org.jfs.drivein.bookingservice.dao;

import java.util.List;
import java.util.Optional;

import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.repository.ParkingSlotRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingSlotDaoImpl implements ParkingSlotDao{

	private final ParkingSlotRepository slotRepository;

	public ParkingSlotDaoImpl(ParkingSlotRepository slotRepository) {
		this.slotRepository = slotRepository;
	}


	@Override
	public void deleteParkingSlot(String id) {
		// TODO Auto-generated method stub
		slotRepository.deleteById(id);
	}

	@Override
	public List<ParkingSlot> findParkingSlot(String title) {
		// TODO Auto-generated method stub
		return slotRepository.findByTitle(title);
	}

	@Override
	public Optional<ParkingSlot> findParkingSlot(String title, String date) {
		// TODO Auto-generated method stub
		return slotRepository.findByTitleAndDate(title, date);
	}

	@Override
	public ParkingSlot saveParkingSlot(ParkingSlot parkingSlot) {
		// TODO Auto-generated method stub
		return slotRepository.save(parkingSlot);
	}

}
