package org.jfs.drivein.bookingservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient
public interface ScheduleClient {

    @GetMapping("price/{id}/{tier}")
    double getPrice(String id, String tier, String slotTime);
}
