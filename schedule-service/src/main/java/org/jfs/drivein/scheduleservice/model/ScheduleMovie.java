package org.jfs.drivein.scheduleservice.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document
public class ScheduleMovie {
	
    @Id
    private String slotId;
    @NotBlank(message = "")
    private String title;
    @Min(value = 1000 , message = "")
    @Max(value = 15000 , message = "")
    private double tier1Price;
    @Min(value = 1000 , message = "")
    @Max(value = 15000 , message = "")
    private double tier2Price;
    @Min(value = 1000 , message = "")
    @Max(value = 15000 , message = "")
    private double tier3Price;
}
