package org.jfs.drivein.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "schedule-service")
public interface ScheduleClient {

	@GetMapping("price/{date}/{tier}/{slotTime}")
	double getPrice(@PathVariable String date, @PathVariable String tier, @PathVariable String slotTime);
}
