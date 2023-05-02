package org.jfs.driveinmovie.driveinmovieapp.resource;

import org.jfs.driveinmovie.driveinmovieapp.model.Schedule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "schedule-service", url = "http://localhost:8050/")
public interface ScheduleResource {

    @PostMapping("add")
    ResponseEntity<Schedule> createSchedule(@RequestBody Schedule schedule);

    @GetMapping("view/{date}")
    Schedule viewSchedule(@PathVariable String date);

    @PutMapping("update/{date}")
    ResponseEntity<Schedule> updateSchedule(@PathVariable String date, @RequestBody Schedule schedule);

    @DeleteMapping("delete/{date}")
    ResponseEntity<?> deleteSchedule(@PathVariable String date);
}
