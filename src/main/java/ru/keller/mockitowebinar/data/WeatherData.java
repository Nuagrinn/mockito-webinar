package ru.keller.mockitowebinar.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String forecast;

    // Default constructor for JPA
    public WeatherData() {
    }

    // Parameterized constructor
    public WeatherData(String location, String forecast) {
        this.location = location;
        this.forecast = forecast;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getForecast() {
        return forecast;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

}



