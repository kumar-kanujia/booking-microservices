package org.jfs.driveinmovie.driveinmovieapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleMovie {

    private String slotId;
    @NotBlank(message = "Title cannot be blank")
    private String title;
    @Min(value = 1000 , message = "Min value should be 1000")
    @Max(value = 15000 , message = "Max value should be 15000")
    private double tier1Price;
    @Min(value = 1000 , message = "Min value should be 1000")
    @Max(value = 15000 , message = "Max value should be 15000")
    private double tier2Price;
    @Min(value = 1000 , message = "Min value should be 1000")
    @Max(value = 15000 , message = "Max value should be 15000")
    private double tier3Price;
}