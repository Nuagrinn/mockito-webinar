package ru.keller.mockitowebinar.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import ru.keller.mockitowebinar.client.WeatherApiClient;

public class WeatherApiClientTest {

    @Mock
    private RestTemplate mockRestTemplate;

    @InjectMocks
    private WeatherApiClient weatherApiClient;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetExternalWeatherData() {
        String location = "Paris";
        String expectedResponse = "Sunny";

        // Define behavior of the mock RestTemplate
        when(mockRestTemplate.getForObject("http://external.weather.api/" + location, String.class))
                .thenReturn(expectedResponse);

        // Call the method under test
        String actualResponse = weatherApiClient.getExternalWeatherData(location);

        // Assertions
        assertEquals(expectedResponse, actualResponse);
    }
}

