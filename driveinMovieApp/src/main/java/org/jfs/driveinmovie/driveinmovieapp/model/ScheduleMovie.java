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

    private String id;
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