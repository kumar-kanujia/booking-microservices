package org.jfs.driveinmovie.driveinmovieapp.resource;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Booking-service", url = "http://localhost:8020/")
public interface BookingResource {
}
