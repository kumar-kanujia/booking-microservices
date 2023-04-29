package org.jfs.driveinmovie.driveinmovieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Ticket {

    private String id;
    private String carNumber;
    private String title;
    private String date;
    private String slotTime;
    private String tier;
    private int seatNo;
    private double price;
}