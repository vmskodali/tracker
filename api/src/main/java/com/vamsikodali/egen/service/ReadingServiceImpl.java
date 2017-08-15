package com.vamsikodali.egen.service;

import com.vamsikodali.egen.Entity.*;
import com.vamsikodali.egen.exception.BadRequestException;
import com.vamsikodali.egen.exception.ResourceNotFoundException;
import com.vamsikodali.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    ReadingRepository repository;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    AlertService alertService;

    @Transactional
    public Reading createReading(Reading reading) {
        System.out.println(reading);
        if(reading == null || reading.getTires() == null) throw new BadRequestException("Null readings cannot be inserted");
        else {
            Vehicle existing = vehicleService.findOne(reading.getVin());
            if(existing != null) {
                repository.createReading(reading);
                alertService.createAlert(reading, existing);
            }else throw new ResourceNotFoundException("Correspoding car not found");
        }
        return reading;
    }

    @Transactional(readOnly = true)
    public List<GeoLocation> findLocationByVehicle(String vin) {
        Vehicle existing = vehicleService.findOne(vin);
        if(existing == null) throw new ResourceNotFoundException("Correspoding car not found");
        List<Reading> readings = findReadingsByVehicle(vin, 30);
        List<GeoLocation> locations = new ArrayList<GeoLocation>();
        if(readings != null)
            for(Reading reading : readings)
                locations.add(new GeoLocation(reading.getLatitude(), reading.getLongitude(), reading.getTimestamp()));
        return locations;
    }

    @Transactional(readOnly = true)
    public List<Reading> findReadingsByVehicle(String vin, int mins) {
        Vehicle existing = vehicleService.findOne(vin);
        if(existing == null) throw new ResourceNotFoundException("Correspoding car not found");
        return repository.findReadingsByVehicle(vin,mins);
    }

}
