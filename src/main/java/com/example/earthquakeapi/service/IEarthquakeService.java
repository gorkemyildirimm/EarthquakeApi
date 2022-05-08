package com.example.earthquakeapi.service;

import com.example.earthquakeapi.model.EarthquakeModel;
import com.example.earthquakeapi.model.EarthquakeResponseModel;
import com.example.earthquakeapi.model.Feature;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface IEarthquakeService {
    EarthquakeResponseModel getEarthquakeApi(Integer countOfDays, String country);

}

