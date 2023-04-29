package org.jfs.driveinmovie.driveinmovieapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingSlot {

    private String id;
    private String title;
    private Date date;
    private String slotTime;
    private int tier1;
    private int tier2;
    private int tier3;
}