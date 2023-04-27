package org.jfs.drivein.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/*
author kumar-kanujia
 */
@Document
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ParkingSlot {
    
	@Id
	private String id;
	private String title;
    private Date date;
    private String slotTime;
    private int typeA;
    private int typeB;
    private int typeC;
}
