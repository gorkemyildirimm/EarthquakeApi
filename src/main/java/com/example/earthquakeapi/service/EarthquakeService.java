package com.example.earthquakeapi.service;

import com.example.earthquakeapi.model.EarthquakeModel;
import com.example.earthquakeapi.model.EarthquakeResponseModel;
import com.example.earthquakeapi.model.Feature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EarthquakeService implements IEarthquakeService{

    private final RestTemplate restTemplate;

    public EarthquakeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public EarthquakeResponseModel getEarthquakeApi(Integer countOfDays, String country) {
        try {
            EarthquakeResponseModel responseModel = new EarthquakeResponseModel();
            LocalDate endDate=LocalDate.now();
            LocalDate startDate=LocalDate.now().minusDays(countOfDays);
            String api ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime="+startDate+"&endtime="+endDate;

            ResponseEntity<EarthquakeModel> result = restTemplate.
                    getForEntity(api, EarthquakeModel.class);
            EarthquakeModel earthquakeModel =result.getBody();


            responseModel.setEarthquakes(earthquakeModel.getFeatures().stream().filter(feature ->
                    feature.getProperties().getCountry().equals(country)).collect(Collectors.toList()));

            if(responseModel.getEarthquakes().isEmpty()) {
              responseModel.setMessage(String.format("No Earthquakes were recorded past %s days.",countOfDays));
            }
            else {
                responseModel.setMessage("Success");
            }

            return responseModel;
        } catch (RestClientException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
