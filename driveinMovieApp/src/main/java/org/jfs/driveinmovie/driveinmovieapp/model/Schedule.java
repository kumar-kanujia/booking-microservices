package org.jfs.driveinmovie.driveinmovieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private String id;
    private String date;
    private ScheduleMovie slot1;
    private ScheduleMovie slot2;
    private ScheduleMovie slot3;
}