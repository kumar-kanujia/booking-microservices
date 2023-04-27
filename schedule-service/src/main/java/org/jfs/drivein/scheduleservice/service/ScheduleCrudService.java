package org.jfs.drivein.scheduleservice.service;

import java.util.Date;

import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;

public interface ScheduleCrudService {

    Schedule addSchedule(Schedule schedule);

	Schedule updateSchedule(Date date, Schedule schedule) throws InvalidScheduleDateException;

	void deleteSchedule(Date date);

	Schedule viewSchedule(Date date) throws InvalidScheduleDateException;
}
