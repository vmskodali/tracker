package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;
import com.vamsikodali.egen.Entity.Tires;
import com.vamsikodali.egen.Entity.Vehicle;

public interface ReadingService {
    Reading createReading(Reading reading);
    void createAlert(Reading reading, Vehicle vehicle);
    boolean isValidTirePressure(Tires tires);
}
