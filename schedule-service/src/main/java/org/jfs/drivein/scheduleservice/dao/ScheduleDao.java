package org.jfs.drivein.scheduleservice.dao;

import java.util.Date;
import java.util.Optional;

import org.jfs.drivein.scheduleservice.model.Schedule;

public interface ScheduleDao {

	Schedule saveSchedule(Schedule schedule);

	Optional<Schedule> viewSchedule(Date date);

	void deleteSchedule(Schedule schedule);
}
