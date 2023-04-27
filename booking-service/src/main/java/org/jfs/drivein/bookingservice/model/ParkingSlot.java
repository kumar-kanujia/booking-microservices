package org.jfs.drivein.bookingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
	private String title;
	private String date;
    private String slotTime;
    private int frontSection;
    private int middleSection;
    private int backSection;

	public ParkingSlot(String title, String date, String slotTime, int frontSection, int middleSection, int backSection) {
		this.title = title;
		this.date = date;
		this.slotTime = slotTime;
		this.frontSection = frontSection;
		this.middleSection = middleSection;
		this.backSection = backSection;
	}

}
