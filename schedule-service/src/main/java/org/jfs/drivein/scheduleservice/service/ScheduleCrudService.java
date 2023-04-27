package org.jfs.drivein.scheduleservice.service;

import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;

public interface ScheduleCrudService {

    Schedule addSchedule(Schedule schedule);

	Schedule updateSchedule(String date, Schedule schedule) throws InvalidScheduleDateException;

	void deleteSchedule(String date) throws InvalidScheduleDateException;

	Schedule viewSchedule(String date) throws InvalidScheduleDateException;
}
