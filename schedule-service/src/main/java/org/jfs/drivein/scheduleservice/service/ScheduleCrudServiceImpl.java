package org.jfs.drivein.scheduleservice.service;

import java.util.Date;
import java.util.Optional;

import org.jfs.drivein.scheduleservice.dao.ScheduleDao;
import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleCrudServiceImpl implements ScheduleCrudService {

	private ScheduleDao dao;

	public ScheduleCrudServiceImpl(ScheduleDao dao) {
		this.dao = dao;
	}

	@Override
	public Schedule addSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		return dao.saveSchedule(schedule);
	}

	@Override
	public Schedule updateSchedule(Date date, Schedule schedule) throws InvalidScheduleDateException {
		// TODO Auto-generated method stub
		Optional<Schedule> optional = dao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException();
		}
		schedule.setId(optional.get().getId());
		schedule.setDate(date);
		return dao.saveSchedule(schedule);
	}

	@Override
	public void deleteSchedule(Date date) {
		// TODO Auto-generated method stub

		dao.deleteSchedule(dao.viewSchedule(date).get());
	}

	@Override
	public Schedule viewSchedule(Date date) throws InvalidScheduleDateException {
		// TODO Auto-generated method stub
		Optional<Schedule> optional = dao.viewSchedule(date);
		if (optional.isEmpty()) {
			throw new InvalidScheduleDateException();
		}
		return optional.get();
	}

}
