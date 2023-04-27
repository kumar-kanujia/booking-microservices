package org.jfs.drivein.bookingservice.resource;

import lombok.AllArgsConstructor;
import org.jfs.drivein.bookingservice.exception.UnavailableSlotException;
import org.jfs.drivein.bookingservice.model.ParkingSlot;
import org.jfs.drivein.bookingservice.service.ParkingSlotService;
import org.springframework.web.bind.annotation.*;
/*
author kumar- 1.0.0
 */

@RestController
@AllArgsConstructor
public class ParkingSlotResource {

    private final ParkingSlotService parkingSlotService;

    @PostMapping("slot/create")
    public void createSlot(@RequestBody ParkingSlot parkingSlot){
        parkingSlotService.createSlot(parkingSlot);
    }

    @PutMapping("slot/update")
    public void updateSlot(@RequestBody ParkingSlot parkingSlot) throws UnavailableSlotException {
        parkingSlotService.updateSlot(parkingSlot);
    }

    @DeleteMapping("slot/delete")
    public  void  deleteSlot(@RequestBody ParkingSlot parkingSlot) throws UnavailableSlotException {
        parkingSlotService.deleteSlot(parkingSlot);
    }
}
