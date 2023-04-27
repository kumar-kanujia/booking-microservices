package org.jfs.drivein.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
author kumar- 1.0.0
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
    private int tier1;
    private int tier2;
    private int tier3;

	public ParkingSlot() {
	}

	public ParkingSlot(String title, String date, String slotTime, int tier1, int tier2, int tier3) {
		this.title = title;
		this.date = date;
		this.slotTime = slotTime;
		this.tier1 = tier1;
		this.tier2 = tier2;
		this.tier3 = tier3;
	}

}
