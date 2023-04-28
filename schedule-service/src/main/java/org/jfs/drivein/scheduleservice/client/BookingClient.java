package org.jfs.drivein.scheduleservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("booking-service")
public interface BookingClient {

	@PostMapping("slot/create/{title}/{date}/{slotTime}")
	void createSlot(@PathVariable String title, @PathVariable String date, @PathVariable String slotTime);

	@PutMapping("slot/update/{title}/{date}/{slotTime}")
	void updateSlot(@PathVariable String title, @PathVariable String date, @PathVariable String slotTime);

	@DeleteMapping("slot/delete/{date}/{slotTime}")
	void deleteSlot(@PathVariable String date, @PathVariable String slotTime);

}
