package org.jfs.drivein.scheduleservice.repository;

import java.util.Date;
import java.util.Optional;

import org.jfs.drivein.scheduleservice.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository extends MongoRepository<Schedule, String> {
	public Optional<Schedule> findByDate(Date date);
}
