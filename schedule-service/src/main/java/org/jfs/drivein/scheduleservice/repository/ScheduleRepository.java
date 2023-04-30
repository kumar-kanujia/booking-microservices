package org.jfs.drivein.scheduleservice.repository;

import java.util.Optional;

import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.data.repository.CrudRepository;


public interface ScheduleRepository extends CrudRepository<Schedule, String> {
	Optional<Schedule> findByDate(String date);
}
