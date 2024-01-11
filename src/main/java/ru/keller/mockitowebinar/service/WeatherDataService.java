package ru.keller.mockitowebinar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.keller.mockitowebinar.data.WeatherData;
import ru.keller.mockitowebinar.repository.WeatherDataRepository;

@Service
public class WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;

    public WeatherDataService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public WeatherData getWeatherData(String location) {
        return weatherDataRepository.findByLocation(location);
    }

    public void saveWeatherData(WeatherData weatherData) {
        weatherDataRepository.save(weatherData);
    }
}
