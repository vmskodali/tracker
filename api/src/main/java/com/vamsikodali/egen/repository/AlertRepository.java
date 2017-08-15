package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Alert;

import java.util.List;

public interface AlertRepository {
    void createAlert(Alert alert);
    List<Alert> findAllAlerts();
    List<Alert> findAlertsByVehicle(String vin);
}
