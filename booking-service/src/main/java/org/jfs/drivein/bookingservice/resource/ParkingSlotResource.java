package org.jfs.drivein.bookingservice.resource;

import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.service.ParkingSlotService;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

/*
author kumar-kanujia
 */
@RestController
@AllArgsConstructor
public class ParkingSlotResource {

    private final ParkingSlotService parkingSlotService;

	@PostMapping("slot/create")
	public void createSlot(@RequestBody ParkingSlot parkingSlot) {
		parkingSlotService.saveSlot(parkingSlot);
    }

	@PutMapping("slot/update/{id}/{title}")
	public void updateSlot(@PathVariable String id, @PathVariable String title)
			throws UnavailableSlotException {
		parkingSlotService.updateSlot(id, title);
    }

	@DeleteMapping("slot/delete/{id}")
	public void deleteSlot(@PathVariable String id)
			throws UnavailableSlotException {
		parkingSlotService.deleteSlot(id);
    }
}
