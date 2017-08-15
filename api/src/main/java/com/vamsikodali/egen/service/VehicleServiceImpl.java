package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.Vehicle;
import com.vamsikodali.egen.exception.BadRequestException;
import com.vamsikodali.egen.exception.ResourceNotFoundException;
import com.vamsikodali.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository repository;
    @Transactional
    public Vehicle[] createVehicle(Vehicle[] vehicles) {
        for(Vehicle vehicle : vehicles){
            if(vehicle != null){
                Vehicle existing = repository.findOne(vehicle.getVin());
                if(existing == null) repository.createVehicle(vehicle);
                else repository.updateVehicle(vehicle);
            }
            else throw new BadRequestException("The Request sent with no vehicle details ");
        }

        return vehicles;
    }


    @Transactional(readOnly = true)
    public Vehicle findOne(String id) {
        Vehicle existing = repository.findOne(id);
        if (existing == null) {
            throw new ResourceNotFoundException("Employee with id " + id + " doesn't exist.");
        }
        return existing;
    }

    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }
}
