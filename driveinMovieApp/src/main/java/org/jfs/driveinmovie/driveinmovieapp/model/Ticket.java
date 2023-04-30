package org.jfs.driveinmovie.driveinmovieapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jfs.driveinmovie.driveinmovieapp.validation.ForwardDateValidation;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Ticket {

    private String id;
    @NotBlank(message = "")
    private String carNumber;
    @NotBlank(message = "")
    private String title;
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
    @NotBlank(message = "")
    @ForwardDateValidation
    private String date;
    @NotBlank(message = "")
    @Pattern(regexp = "^[a-c]$")
    private String slotTime;
    @NotBlank(message = "")
    @Pattern(regexp = "^[x-z]$")
    private String tier;
    @Min(value = 1 , message="")
    @Max(value = 20 , message = "")
    private int seatNo;
    @Min(value = 1000 , message = "")
    @Max(value = 15000 , message = "")
    private double price;
}