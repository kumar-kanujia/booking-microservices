package org.jfs.driveinmovie.driveinmovieapp.model;

import jakarta.validation.constraints.Max;
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
public class ParkingSlot {

    private String id;
    @NotBlank(message = "")
    private String title;
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
    @NotBlank(message = "")
    @ForwardDateValidation
    private String date;
    @NotBlank(message = "")
    @Pattern(regexp = "^[x-z]$")
    private String slotTime;
    @Max(value = 20 , message = "")
    private int tier1;
    @Max(value = 20 , message = "")
    private int tier2;
    @Max(value = 20 , message = "")
    private int tier3;
}