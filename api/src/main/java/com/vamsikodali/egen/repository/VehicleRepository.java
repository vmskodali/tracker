package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    void createVehicle(Vehicle v);
    void updateVehicle(Vehicle v);
    Vehicle findOne(String id);
    List<Vehicle> findAll();
}
