package ru.keller.mockitowebinar.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import ru.keller.mockitowebinar.data.WeatherData;
import ru.keller.mockitowebinar.repository.WeatherDataRepository;
import ru.keller.mockitowebinar.service.WeatherDataService;

public class WeatherDataServiceTest {

    @Mock
    private WeatherDataRepository mockWeatherDataRepository;

    @InjectMocks
    private WeatherDataService weatherDataService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetWeatherData() {
        String location = "Paris";
        WeatherData mockWeatherData = new WeatherData();
        mockWeatherData.setLocation(location);
        mockWeatherData.setForecast("Sunny");

        when(mockWeatherDataRepository.findByLocation(location)).thenReturn(mockWeatherData);

        WeatherData result = weatherDataService.getWeatherData(location);

        assertNotNull(result);
        assertEquals("Sunny", result.getForecast());
    }

    @Test
    public void testSaveWeatherData() {
        WeatherData newWeatherData = new WeatherData();
        newWeatherData.setLocation("London");
        newWeatherData.setForecast("Rainy");

        weatherDataService.saveWeatherData(newWeatherData);

        verify(mockWeatherDataRepository).save(newWeatherData);
    }
}

