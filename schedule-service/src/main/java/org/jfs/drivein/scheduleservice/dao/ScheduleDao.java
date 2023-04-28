package org.jfs.drivein.scheduleservice.dao;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.model.Schedule;

/*
author kumar-kanujia
 */
public interface ScheduleDao {

	Schedule saveSchedule(Schedule schedule);

	Optional<Schedule> viewSchedule(String date);

	void deleteSchedule(Schedule schedule);
}
