package org.jfs.drivein.scheduleservice.dao;

import lombok.AllArgsConstructor;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.repository.ScheduleRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
author kumar-kanujia
 */

@Repository
@AllArgsConstructor
public class ScheduleDaoImpl implements ScheduleDao {

	private final ScheduleRepository repository;

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

	@Override
	public Optional<Schedule> viewScheduleById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}



}
