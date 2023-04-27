package org.jfs.drivein.scheduleservice.resource;

import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.service.ScheduleCrudService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public Schedule viewSchedule(@PathVariable String date) throws InvalidScheduleDateException {
		return crudService.viewSchedule(date);
	}

	@PutMapping("update/{date}")
	public Schedule updateSchedule(@PathVariable String date, @RequestBody Schedule schedule)
			throws InvalidScheduleDateException {
		return crudService.updateSchedule(date, schedule);
	}

	@DeleteMapping("delete/{date}")
	public void deleteSchedule(@PathVariable String date) {
		crudService.deleteSchedule(date);
	}
}
