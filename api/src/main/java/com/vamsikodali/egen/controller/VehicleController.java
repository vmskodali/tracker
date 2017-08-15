package com.vamsikodali.egen.controller;


import com.vamsikodali.egen.Entity.Reading;
import com.vamsikodali.egen.Entity.Tires;
import com.vamsikodali.egen.Entity.Vehicle;
import com.vamsikodali.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {


    @Autowired
    VehicleService service;

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.PUT)
    public Vehicle[] create(@RequestBody Vehicle[] vehicles) {
        service.createVehicle(vehicles);
        return vehicles;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> findAll() {
        return service.findAll();
    }


}
