package org.jfs.drivein.scheduleservice.service;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.stereotype.Service;

@Service
public class ScheduleCrudServiceImpl implements ScheduleCrudService {

	private ScheduleDao scheduleDao;

	public ScheduleCrudServiceImpl(ScheduleDao dao) {
		this.scheduleDao = dao;
	}

	@Override
	public Schedule addSchedule(Schedule schedule) {
		return scheduleDao.saveSchedule(schedule);
	}

	@Override
	public Schedule updateSchedule(String date, Schedule schedule) throws InvalidScheduleDateException {
		Optional<Schedule> optional = scheduleDao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException("Please enter valid date");
		}
		schedule.setId(optional.get().getId());
		schedule.setDate(date);
		return scheduleDao.saveSchedule(schedule);
	}

	@Override
	public void deleteSchedule(String date) {
		scheduleDao.deleteSchedule(scheduleDao.viewSchedule(date).get());
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
