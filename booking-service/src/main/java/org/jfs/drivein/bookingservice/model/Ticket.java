package org.jfs.drivein.bookingservice.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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
    private Date date;
    private String slotTime;
    private String parkingSlotNumber;
    private double price;
}
