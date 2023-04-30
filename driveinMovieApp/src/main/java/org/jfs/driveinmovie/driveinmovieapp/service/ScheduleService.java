package org.jfs.driveinmovie.driveinmovieapp.service;

import lombok.AllArgsConstructor;
import org.jfs.driveinmovie.driveinmovieapp.exception.InvalidScheduleDateException;
import org.jfs.driveinmovie.driveinmovieapp.exception.ServiceDownException;
import org.jfs.driveinmovie.driveinmovieapp.model.Schedule;
import org.jfs.driveinmovie.driveinmovieapp.resource.ScheduleResource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleResource scheduleResource;
    public void addSchedule(Schedule schedule) throws ServiceDownException {
        if (! scheduleResource.createSchedule(schedule).getStatusCode().isSameCodeAs(HttpStatus.CREATED)){
            throw new ServiceDownException("");
        }
    }

    public Schedule viewSchedule(String date) throws InvalidScheduleDateException {
        Schedule schedule = scheduleResource.viewSchedule(date);
        if (schedule==null){
            throw new InvalidScheduleDateException("");
        }
        return schedule;
    }


    public void updateSchedule(Schedule schedule) throws ServiceDownException {
        if (! scheduleResource.updateSchedule(schedule.getDate(), schedule).getStatusCode().isSameCodeAs(HttpStatus.ACCEPTED)){
            throw new ServiceDownException("");
        }
    }

    public void deleteSchedule(String date) throws ServiceDownException {
        if (! scheduleResource.deleteSchedule(date).getStatusCode().isSameCodeAs(HttpStatus.NO_CONTENT)){
            throw new ServiceDownException("");
        }
    }




}
