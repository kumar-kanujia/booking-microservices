package org.jfs.driveinmovie.driveinmovieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private String id;

    private Date date;

    private ScheduleMovie slot1;
    private ScheduleMovie slot2;
    private ScheduleMovie slot3;
}