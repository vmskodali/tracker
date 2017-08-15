package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.*;

import java.util.List;

public interface ReadingService {
    Reading createReading(Reading reading);
    List<GeoLocation> findLocationByVehicle(String vin);
    List<Reading> findReadingsByVehicle(String vin);

}
