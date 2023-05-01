package org.jfs.driveinmovie.driveinmovieapp.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jfs.driveinmovie.driveinmovieapp.validation.ForwardDateValidation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    private String id;
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
    @NotBlank(message = "")
    @ForwardDateValidation(message = "Date should be a future date")
    private String date;
    @Valid
    private ScheduleMovie slot1;
    @Valid
    private ScheduleMovie slot2;
    @Valid
    private ScheduleMovie slot3;
}