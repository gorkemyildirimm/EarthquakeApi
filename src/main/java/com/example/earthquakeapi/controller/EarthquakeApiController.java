package com.example.earthquakeapi.controller;

import com.example.earthquakeapi.model.EarthquakeResponseModel;
import com.example.earthquakeapi.service.EarthquakeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(path = "/api")
@Validated
public class EarthquakeApiController {
    private final EarthquakeService service;
        //Input country/past {x} days
    public EarthquakeApiController(EarthquakeService service) {
        this.service = service;
    }
    @GetMapping(path="{country}/{countOfDays}")
    public EarthquakeResponseModel getEarthquakeApi(
            @PathVariable String country,
            @PathVariable Integer countOfDays
            )
    {
        return service.getEarthquakeApi(countOfDays,country);
    }
}
