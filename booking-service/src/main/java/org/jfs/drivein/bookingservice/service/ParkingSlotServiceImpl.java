package org.jfs.drivein.bookingservice.service;

import java.util.List;
import java.util.Optional;

import org.jfs.drivein.bookingservice.dao.ParkingSlotDao;
import org.jfs.drivein.bookingservice.exception.NoSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.proxy.ScheduleProxy;
import org.springframework.stereotype.Service;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
	
	private final ParkingSlotDao dao;


	public ParkingSlotServiceImpl(ParkingSlotDao dao, ScheduleProxy proxy) {
		this.dao = dao;
	}

	@Override
	public ParkingSlot createSlot(String title, String date, String slotTime) {
		// TODO Auto-generated method stub
		return dao.saveParkingSlot(new ParkingSlot(title, date, slotTime, 20, 20, 20));
	}

	@Override
	public ParkingSlot updateSlot(ParkingSlot parkingSlot) {
		// TODO Auto-generated method stub
		return dao.saveParkingSlot(parkingSlot);
	}

	@Override
	public void deleteSlot(String id) {
		// TODO Auto-generated method stub
		dao.deleteParkingSlot(id);

	}

	@Override
	public List<ParkingSlot> findParkingSlotByTitle(String title) throws NoSlotException {
		// TODO Auto-generated method stub
		List<ParkingSlot> parkingSlots = dao.findParkingSlot(title);
		if (parkingSlots.isEmpty()) {
			throw new NoSlotException("");
		}
		return parkingSlots;
	}

	@Override
	public ParkingSlot findParkingSlotByTitleAndDate(String title, String date) throws NoSlotException {
		// TODO Auto-generated method stub
		Optional<ParkingSlot> optional = dao.findParkingSlot(title, date);
		if (optional.isEmpty()) {
			throw new NoSlotException("");
		}
		return optional.get();
	}

}
