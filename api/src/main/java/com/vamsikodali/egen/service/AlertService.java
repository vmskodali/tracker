package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;
import com.vamsikodali.egen.Entity.Tires;
import com.vamsikodali.egen.Entity.Vehicle;

import java.util.List;

public interface AlertService {
    void createAlert(Reading reading, Vehicle vehicle);
    boolean isValidTirePressure(Tires tires);
    List<Alert> findAllAlerts();
    List<Alert> findAlertsByVehicle(String vin);
}
