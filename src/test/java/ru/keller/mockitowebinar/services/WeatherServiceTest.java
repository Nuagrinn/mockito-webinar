package ru.keller.mockitowebinar.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ru.keller.mockitowebinar.client.WeatherClient;
import ru.keller.mockitowebinar.service.WeatherService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WeatherServiceTest {

    @Mock
    private WeatherClient mockWeatherClient;

    @InjectMocks
    private WeatherService weatherService;

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        // Modify the filePath in WeatherService to point to a temporary directory
        weatherService.setFilePath(tempDir.resolve("weather_data.txt"));
    }

    @Test
    public void testGetWeatherForecast() {
        String location = "Paris";
        String expectedForecast = "Sunny";

        // Define behavior of the mock
        when(mockWeatherClient.getForecast(location)).thenReturn(expectedForecast);

        // Call the method under test
        String actualForecast = weatherService.getWeatherForecast(location);

        // Assertions
        assertEquals(expectedForecast, actualForecast);
    }

    @Test
    public void testReadWeatherDataFromFile() throws IOException {
        String sampleForecast = "Cloudy";
        Files.writeString(tempDir.resolve("weather_data.txt"), sampleForecast);

        String readData = weatherService.readWeatherDataFromFile();

        assertEquals(sampleForecast, readData);
    }
}
