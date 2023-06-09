package org.jfs.drivein.scheduleservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jfs.drivein.scheduleservice.validation.ForwardDateValidation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
	
    @Id
    private String id;
    @Pattern(regexp="^\\d{4}-\\d{2}-\\d{2}$", message = "Date must be in the format yyyy-MM-dd")
	@Indexed(unique = true)
    @NotBlank(message = "")
    @ForwardDateValidation
	private String date;
	@Valid
    private ScheduleMovie slot1;
	@Valid
    private ScheduleMovie slot2;
	@Valid
    private ScheduleMovie slot3;

}
