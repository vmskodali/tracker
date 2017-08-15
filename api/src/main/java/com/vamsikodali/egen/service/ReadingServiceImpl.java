package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.*;
import com.vamsikodali.egen.exception.BadRequestException;
import com.vamsikodali.egen.exception.ResourceNotFoundException;
import com.vamsikodali.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;
    @Autowired
    VehicleService vehicleService;

    @Transactional
    public Reading createReading(Reading reading) {
        System.out.println(reading);
        if(reading == null || reading.getTires() == null) throw new BadRequestException("Null readings cannot be inserted");
        else {
            Vehicle existing = vehicleService.findOne(reading.getVin());
            if(existing != null) {
                repository.createReading(reading);
                createAlert(reading, existing);
            }else throw new ResourceNotFoundException("Correspoding car not found");
        }
        return reading;
    }
    @Transactional
    public void createAlert(Reading reading, Vehicle vehicle){
        if(reading.getEngineRpm() > vehicle.getRedLineRpm())
            repository.createAlert(new Alert(vehicle, reading, Priority.HIGH, AlertType.ENGINERPM));
        if(reading.getFuelVolume() < 0.1 * vehicle.getMaxFuelVolume())
            repository.createAlert(new Alert(vehicle, reading, Priority.MEDIUM, AlertType.FUELVOLUME));
        if(reading.isEngineCoolantLow())
            repository.createAlert(new Alert(vehicle, reading, Priority.LOW, AlertType.ENGINECOOLANTLOW));
        if(reading.isCheckEngineLightOn())
            repository.createAlert(new Alert(vehicle, reading, Priority.LOW, AlertType.ENGINELIGHTON));
        if(!isValidTirePressure(reading.getTires()))
            repository.createAlert(new Alert(vehicle, reading, Priority.LOW, AlertType.TIREPRESSURE));

    }

    public boolean isValidTirePressure(Tires tires){
        if(tires.getFrontLeft() > 36 || tires.getFrontLeft() < 32)
            return false;
        else if(tires.getFrontRight() > 36 || tires.getFrontRight() < 32)
            return false;
        if(tires.getRearLeft() > 36 || tires.getRearLeft() < 32)
            return false;
        else if(tires.getRearRight() > 36 || tires.getRearRight() < 32)
            return false;
        else return true;
    }
}
