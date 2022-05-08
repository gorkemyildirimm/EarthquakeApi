package com.example.earthquakeapi.model;

import lombok.Data;

import java.util.List;

@Data
public class EarthquakeResponseModel {
    private String Message;
    private List<Feature> earthquakes;
}
