package org.jfs.drivein.bookingservice.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ticket {

    @Id
    private String id;
    private String carNumber;
    private String title;
	private String date;
    private String slotTime;
    private String parkingSlotNumber;
    private double price;
}
