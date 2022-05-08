package com.example.earthquakeapi.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class EarthquakeModel {
    private String type;
    private ArrayList<Properties> properties;
    private ArrayList<Feature> features;


}
