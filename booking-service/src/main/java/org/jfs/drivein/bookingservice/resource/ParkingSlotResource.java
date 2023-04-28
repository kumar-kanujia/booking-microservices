package org.jfs.drivein.bookingservice.resource;

import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.service.ParkingSlotService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

/*
author kumar-kanujia
 */
@RestController
@AllArgsConstructor
public class ParkingSlotResource {

    private final ParkingSlotService parkingSlotService;

	@PostMapping("slot/create/{title}/{date}/{slotTime}")
	public void createSlot(@PathVariable String title, @PathVariable String date, @PathVariable String slotTime) {
		parkingSlotService.createSlot(title, date, slotTime);
    }

	@PutMapping("slot/update/{title}/{date}/{slotTime}")
	public void updateSlot(@PathVariable String title, @PathVariable String date, @PathVariable String slotTime)
			throws UnavailableSlotException {
		parkingSlotService.updateSlot(title, date, slotTime);
    }

	@DeleteMapping("slot/delete/{date}/{slotTime}")
	public void deleteSlot(@PathVariable String date, @PathVariable String slotTime)
			throws UnavailableSlotException {
		parkingSlotService.deleteSlot(date, slotTime);
    }
}
