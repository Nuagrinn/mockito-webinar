package ru.keller.mockitowebinar.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiClient {

    private final RestTemplate restTemplate;

    public WeatherApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getExternalWeatherData(String location) {
        String url = "http://external.weather.api/" + location; // Example URL
        return restTemplate.getForObject(url, String.class);
    }
}

