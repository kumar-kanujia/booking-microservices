package org.jfs.drivein.scheduleservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Schedule {

    private String id;
	private String date;
    private ScheduleMovie slot1;
    private ScheduleMovie slot2;
    private ScheduleMovie slot3;
}
