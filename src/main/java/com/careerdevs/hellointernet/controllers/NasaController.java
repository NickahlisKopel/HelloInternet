package com.careerdevs.hellointernet.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/nasa")
public class NasaController {
    private String myNasaKey = "L6da3GqyJ952ZDnK9RAV04qYAJP3UT5f4f6wyLgh";
    // private String date = "2021-03-03";
    private String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=" + myNasaKey;

    @GetMapping("/apod/{date}")
    public Object apodHandler (RestTemplate restTemplate, @PathVariable("date") String date) {
        Object requestData = restTemplate.getForObject(nasaApodEndpoint + "&date="+date, Object.class);
        return requestData;
    }



}
