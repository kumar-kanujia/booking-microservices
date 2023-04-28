package org.jfs.drivein.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("schedule-service")
public interface ScheduleClient {

	@GetMapping("price/{id}/{tier}/{slotTime}")
	double getPrice(@PathVariable String id, @PathVariable String tier, @PathVariable String slotTime);
}
