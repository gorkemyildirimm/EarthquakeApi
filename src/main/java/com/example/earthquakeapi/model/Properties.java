package com.example.earthquakeapi.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"country","place","mag","time"})
public class Properties {

    private String place;
    private double mag;
    private Object time;
    public Date getTime() {
        return new Date((long) time);
    }
    public String getCountry() {
        try {
            int ind = this.place.indexOf(',')+1;
            return this.place.substring(ind).trim();
            //return this.place.substring(this.place.lastIndexOf(" ")+1;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
