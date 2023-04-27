package org.jfs.drivein.scheduleservice.resource;

import java.util.Date;

import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.service.ScheduleCrudService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

@RestController
public class ScheduleResource {

	private ScheduleCrudService crudService;

	public ScheduleResource(ScheduleCrudService crudService) {
		this.crudService = crudService;
	}

	@PostMapping("add")
	public Schedule addSchedule(@RequestBody Schedule schedule) {
		return crudService.addSchedule(schedule);
	}

	@GetMapping("view/{date}")
	public Schedule viewSchedule(@RequestParam Date date) throws InvalidScheduleDateException {
		return crudService.viewSchedule(date);
	}

	@PutExchange("update/{date}")
	public Schedule updateSchedule(Date date, Schedule schedule) throws InvalidScheduleDateException {
		return crudService.updateSchedule(date, schedule);
	}

	@DeleteMapping("delete/{date}")
	public void deleteSchedule(@RequestBody Date date) {
		crudService.deleteSchedule(date);
	}
}
