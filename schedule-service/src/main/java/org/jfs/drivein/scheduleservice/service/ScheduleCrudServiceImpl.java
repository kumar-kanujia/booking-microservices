package org.jfs.drivein.scheduleservice.service;

import lombok.AllArgsConstructor;
import org.jfs.drivein.scheduleservice.client.BookingClient;
import org.jfs.drivein.scheduleservice.config.PropertiesConfig;
import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ScheduleCrudServiceImpl implements ScheduleCrudService {

	private final ScheduleDao scheduleDao;

	private final BookingClient bookingClient;

	private final PropertiesConfig propertiesConfig;

	@Override
	public void addSchedule(Schedule schedule) {
		bookingClient.createSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeA());
		bookingClient.createSlot(schedule.getSlot2().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeB());
		bookingClient.createSlot(schedule.getSlot3().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeC()
		);
        scheduleDao.saveSchedule(schedule);
    }

	@Override
	public Schedule updateSchedule(String date, Schedule schedule) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		bookingClient.updateSlot(schedule.getSlot1().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeA());
		bookingClient.updateSlot(schedule.getSlot2().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeB());
		bookingClient.updateSlot(schedule.getSlot3().getTitle(), schedule.getDate(), propertiesConfig.getSlotTimeC());
		schedule.setId(optional.get().getId());
		schedule.setDate(date);
		return scheduleDao.saveSchedule(schedule);
	}

	@Override
	public void deleteSchedule(String date) throws InvalidScheduleDateException {
		Schedule schedule = scheduleDao.viewSchedule(date).orElse(null);
		if (schedule == null) {
			throw new InvalidScheduleDateException("");
		}
		bookingClient.deleteSlot(schedule.getDate(), propertiesConfig.getSlotTimeA());
		bookingClient.deleteSlot(schedule.getDate(), propertiesConfig.getSlotTimeB());
		bookingClient.deleteSlot(schedule.getDate(), propertiesConfig.getSlotTimeC());
		scheduleDao.deleteSchedule(schedule);
	}

	@Override
	public Schedule viewSchedule(String date) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		return optional.get();
	}

	@Override
	public double getPrice(String id, String tier, String slotTime) throws InvalidScheduleDateException {
		// TODO Auto-generated method stub
		Optional<Schedule> scheduleOptional = scheduleDao.viewScheduleById(id);
		double price;
		if (scheduleOptional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
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
				price = schedule.getSlot2().getTier2Price();
		} else {
			if (slotTime.equals(propertiesConfig.getSlotTimeA()))
				price = schedule.getSlot3().getTier3Price();
			else if (slotTime.equals(propertiesConfig.getSlotTimeB()))
				price = schedule.getSlot3().getTier3Price();
			else
				price = schedule.getSlot3().getTier3Price();
		}
		return price;
	}

}
