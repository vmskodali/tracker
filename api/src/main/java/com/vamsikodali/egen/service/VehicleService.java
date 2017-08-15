package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle[] createVehicle(Vehicle v[]);
    Vehicle findOne(String id);
    List<Vehicle> findAll();
}
