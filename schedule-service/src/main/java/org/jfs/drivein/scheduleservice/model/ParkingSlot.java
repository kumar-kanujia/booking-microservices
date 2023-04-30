package org.jfs.drivein.scheduleservice.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jfs.drivein.scheduleservice.validation.ForwardDateValidation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/*
author kumar-kanujia
 */

@Document
@Getter
@Setter
@AllArgsConstructor
public class ParkingSlot {

	@Id
	private String id;
	@NotBlank(message = "")
	private String title;
	@Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
	@Indexed(unique = true)
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

