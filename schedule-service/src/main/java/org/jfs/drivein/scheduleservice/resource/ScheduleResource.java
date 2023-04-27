package org.jfs.drivein.scheduleservice.resource;

import java.net.URI;

import org.jfs.drivein.scheduleservice.exception.InvalidScheduleDateException;
import org.jfs.drivein.scheduleservice.model.Schedule;
import org.jfs.drivein.scheduleservice.service.ScheduleCrudService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class ScheduleResource {

	private ScheduleCrudService crudService;

	public ScheduleResource(ScheduleCrudService crudService) {
		this.crudService = crudService;
	}

	@PostMapping("add")
	public ResponseEntity<Schedule> addSchedule(@RequestBody @Valid Schedule schedule , HttpServletRequest request) {
		crudService.addSchedule(schedule);
		URI uri = ServletUriComponentsBuilder.fromContextPath(request).path("view/{date}").buildAndExpand(schedule.getDate()).toUri();
		return ResponseEntity.created(uri).body(schedule);
	}

	@GetMapping("view/{date}")
	public Schedule viewSchedule(@PathVariable String date) throws InvalidScheduleDateException {
		return crudService.viewSchedule(date);
	}

	@PutMapping("update/{date}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable String date, @RequestBody @Valid Schedule schedule)
			throws InvalidScheduleDateException {
		schedule = crudService.updateSchedule(date, schedule);
		return ResponseEntity.accepted().body(schedule);
	}

	@DeleteMapping("delete/{date}")
	public ResponseEntity<?> deleteSchedule(@PathVariable String date) throws InvalidScheduleDateException {
		crudService.deleteSchedule(date);
		return ResponseEntity.noContent().build();
	}
}
