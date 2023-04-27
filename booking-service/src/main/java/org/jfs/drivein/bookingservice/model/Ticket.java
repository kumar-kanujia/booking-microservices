package org.jfs.drivein.bookingservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
author kumar- 1.0.0
 */

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
    private String tier;
    private int seatNo;
    private double price;

    public Ticket() {
    }
}
