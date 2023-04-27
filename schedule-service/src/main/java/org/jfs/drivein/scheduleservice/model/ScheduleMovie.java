package org.jfs.drivein.scheduleservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
public class ScheduleMovie {
    @Id
    private String title;
    private double tier1Price;
    private double tier2Price;
    private double tier3Price;
}
