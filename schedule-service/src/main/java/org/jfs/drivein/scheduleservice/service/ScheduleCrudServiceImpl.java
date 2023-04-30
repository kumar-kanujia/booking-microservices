package org.jfs.drivein.scheduleservice.service;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.client.BookingClient;
import org.jfs.drivein.scheduleservice.config.PropertiesConfig;
import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.ParkingSlot;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScheduleCrudServiceImpl implements ScheduleCrudService {

	private final ScheduleDao scheduleDao;

	private final BookingClient bookingClient;

	private final PropertiesConfig propertiesConfig;

	@Override
	public Schedule viewSchedule(String date) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		return optional.get();
	}

	@Override
	public void addSchedule(Schedule schedule) {
		//Working
		ParkingSlot parkingSlot1 = new ParkingSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeA(), 20, 20, 20);
		ParkingSlot parkingSlot2 =	 new ParkingSlot(schedule.getSlot2().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeB(), 20, 20, 20);
		ParkingSlot parkingSlot3 = new ParkingSlot(schedule.getSlot3().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeC(), 20, 20, 20);
		schedule.getSlot1().setSlotId(bookingClient.createSlot(parkingSlot1).getId());
		schedule.getSlot2().setSlotId(bookingClient.createSlot(parkingSlot2).getId());
		schedule.getSlot3().setSlotId(bookingClient.createSlot(parkingSlot3).getId());
		scheduleDao.saveSchedule(schedule);
    }

	@Override
	public Schedule updateSchedule(String date, Schedule schedule) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		Schedule scheduleToGetId = optional.get();
		bookingClient.updateSlot(scheduleToGetId.getSlot1().getSlotId(),schedule.getSlot1().getTitle());
		bookingClient.updateSlot(scheduleToGetId.getSlot2().getSlotId(),schedule.getSlot2().getTitle());
		bookingClient.updateSlot(scheduleToGetId.getSlot3().getSlotId(),schedule.getSlot3().getTitle());
		schedule.setId(optional.get().getId());
		schedule.setDate(date);
		schedule.getSlot1().setSlotId(scheduleToGetId.getSlot1().getSlotId());
		schedule.getSlot2().setSlotId(scheduleToGetId.getSlot2().getSlotId());
		schedule.getSlot3().setSlotId(scheduleToGetId.getSlot3().getSlotId());
		return scheduleDao.saveSchedule(schedule);
	}

	@Override
	public void deleteSchedule(String date) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		Schedule schedule = optional.get();
		bookingClient.deleteSlot(schedule.getSlot1().getSlotId());
		bookingClient.deleteSlot(schedule.getSlot2().getSlotId());
		bookingClient.deleteSlot(schedule.getSlot3().getSlotId());
		scheduleDao.deleteSchedule(schedule);
	}

	@Override
	public double getPrice(String id, String tier, String slotTime) throws InvalidScheduleDateException {
		// TODO Auto-generated method stub
		Optional<Schedule> scheduleOptional = scheduleDao.viewScheduleById(id);
		double price;
		if (scheduleOptional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid ID");
		}
		Schedule schedule = scheduleOptional.get();
		if (tier.equals("a")) {
			if (slotTime.equals(propertiesConfig.getSlotTimeA()))
				price = schedule.getSlot1().getTier1Price();
			else if (slotTime.equals(propertiesConfig.getSlotTimeB()))
				price = schedule.getSlot2().getTier1Price();
			else
				price = schedule.getSlot3().getTier1Price();
		} else if (tier.equals("b")) {
			if (slotTime.equals(propertiesConfig.getSlotTimeA()))
				price = schedule.getSlot1().getTier2Price();
			else if (slotTime.equals(propertiesConfig.getSlotTimeB()))
				price = schedule.getSlot2().getTier2Price();
			else
				price = schedule.getSlot3().getTier2Price();
		} else {
			if (slotTime.equals(propertiesConfig.getSlotTimeA()))
				price = schedule.getSlot1().getTier3Price();
			else if (slotTime.equals(propertiesConfig.getSlotTimeB()))
				price = schedule.getSlot2().getTier3Price();
			else
				price = schedule.getSlot3().getTier3Price();
		}
		return price;
	}

}
