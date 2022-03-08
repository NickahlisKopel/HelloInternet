package com.careerdevs.hellointernet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/nasa")

public class NasaController {
    @Autowired
    private Environment env;

    // private String date = "2021-03-03";
    public String nasaApodEndpoint = "https://api.nasa.gov/planetary/apod?api_key=";
    @GetMapping("/apod/{date}")
    public Object apodHandler (RestTemplate restTemplate, @PathVariable("date") String date) {
        String apiKey = env.getProperty("NASA_API_KEY");
        Object requestData = restTemplate.getForObject(nasaApodEndpoint +apiKey+ "&date="+date, Object.class);
        return requestData;
    }

    @GetMapping("/port")
    public String portTest(){
        return env.getProperty("server.port");
    }



}
