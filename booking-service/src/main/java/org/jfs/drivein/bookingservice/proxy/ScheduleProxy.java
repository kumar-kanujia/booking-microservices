package org.jfs.drivein.bookingservice.proxy;

import org.springframework.stereotype.Component;

@Component
public class ScheduleProxy {

    public double getPrice(String id, String tier) {
        return  1000.00;
    }
}
