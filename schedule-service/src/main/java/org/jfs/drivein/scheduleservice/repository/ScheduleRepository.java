package org.jfs.drivein.scheduleservice.repository;

import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ScheduleRepository extends CrudRepository<Schedule, String> {
	Optional<Schedule> findByDate(String date);
}
