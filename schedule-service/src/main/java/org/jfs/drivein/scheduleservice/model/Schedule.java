package org.jfs.drivein.scheduleservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
@AllArgsConstructor
public class Schedule {
	
    @Id
    private String id;
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
	private String date;
    private ScheduleMovie slot1;
    private ScheduleMovie slot2;
    private ScheduleMovie slot3;
}
