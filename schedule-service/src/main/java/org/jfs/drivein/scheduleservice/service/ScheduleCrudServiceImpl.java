package org.jfs.drivein.scheduleservice.service;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.proxy.BookingProxy;
import org.springframework.stereotype.Service;

@Service
public class ScheduleCrudServiceImpl implements ScheduleCrudService {

	private final ScheduleDao scheduleDao;

	private final BookingProxy bookingProxy;

	public ScheduleCrudServiceImpl(ScheduleDao dao, BookingProxy bookingProxy) {
		this.scheduleDao = dao;
		this.bookingProxy = bookingProxy;
	}

	@Override
	public Schedule addSchedule(Schedule schedule) {
		bookingProxy.createSlot(schedule.getSlot1().getTitle(), schedule.getDate(), "A");
		bookingProxy.createSlot(schedule.getSlot2().getTitle(), schedule.getDate(), "B");
		bookingProxy.createSlot(schedule.getSlot3().getTitle(), schedule.getDate(), "C");
		return scheduleDao.saveSchedule(schedule);
	}

	@Override
	public Schedule updateSchedule(String date, Schedule schedule) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		bookingProxy.updateSlot(schedule.getSlot1().getTitle(), schedule.getDate(), "A");
		bookingProxy.updateSlot(schedule.getSlot2().getTitle(), schedule.getDate(), "B");
		bookingProxy.updateSlot(schedule.getSlot3().getTitle(), schedule.getDate(), "C");
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
		bookingProxy.updateSlot(schedule.getSlot1().getTitle(), schedule.getDate(), "A");
		bookingProxy.updateSlot(schedule.getSlot2().getTitle(), schedule.getDate(), "B");
		bookingProxy.updateSlot(schedule.getSlot3().getTitle(), schedule.getDate(), "C");
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

}
