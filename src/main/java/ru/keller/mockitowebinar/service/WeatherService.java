package ru.keller.mockitowebinar.service;

import ru.keller.mockitowebinar.client.WeatherClient;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WeatherService {
    private WeatherClient weatherClient;
    private Path filePath = Paths.get("weather_data.txt");

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public String getWeatherForecast(String location) {
        return weatherClient.getForecast(location);
    }

    public void saveWeatherDataToFile(String location) throws IOException {
        String forecast = weatherClient.getForecast(location);
        Files.writeString(filePath, forecast);
    }

    public String readWeatherDataFromFile() throws IOException {
        return Files.readString(filePath);
    }



}
