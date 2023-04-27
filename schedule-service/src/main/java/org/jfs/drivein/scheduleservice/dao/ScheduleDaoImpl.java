package org.jfs.drivein.scheduleservice.dao;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.repository.ScheduleRepository;
import org.springframework.stereotype.Component;

@Component
public class ScheduleDaoImpl implements ScheduleDao {

	private final ScheduleRepository repository;

	public ScheduleDaoImpl(ScheduleRepository repository) {
		this.repository = repository;
	}

	@Override
	public Schedule saveSchedule(Schedule schedule) {
		return repository.save(schedule);
	}

	@Override
	public Optional<Schedule> viewSchedule(String date) {
		return repository.findByDate(date);
	}

	@Override
	public void deleteSchedule(Schedule schedule) {
		repository.delete(schedule);
	}

}
