package org.jfs.drivein.scheduleservice.client;

import org.jfs.drivein.scheduleservice.model.ParkingSlot;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "booking-service")
public interface BookingClient {

	@PostMapping("slot/create")
	ParkingSlot createSlot(@RequestBody ParkingSlot parkingSlot);

	@PutMapping("slot/update/{id}/{title}")
	void updateSlot(@PathVariable String id, @PathVariable String title);

	@DeleteMapping("slot/delete/{id}")
	void deleteSlot(@PathVariable String id);

}
