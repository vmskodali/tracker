package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;

import java.util.List;

public interface ReadingRepository {
    void createReading(Reading reading);
    List<Reading> findReadingsByVehicle(String vin, int mins);

}
