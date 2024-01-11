package ru.keller.mockitowebinar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.keller.mockitowebinar.data.WeatherData;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    WeatherData findByLocation(String location);
}