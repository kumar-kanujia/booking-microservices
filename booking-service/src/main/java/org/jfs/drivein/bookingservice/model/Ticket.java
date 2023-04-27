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
    private int id;
    private String carNumber;
    private String movieTitle;
    private Date movieDate;
    private String slotTime;
    private String slotNumber;
    private double price;
}
