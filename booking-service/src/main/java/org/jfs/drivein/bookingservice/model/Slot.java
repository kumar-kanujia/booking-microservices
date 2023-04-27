package org.jfs.drivein.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
public class Slot {

    private Date date;
    private String slotTime;
    private String title;
    private int typeA;
    private int typeB;
    private int typeC;
}
