package com.vamsikodali.egen.controller;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;
import com.vamsikodali.egen.Entity.Vehicle;
import com.vamsikodali.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {
    @Autowired
    ReadingService service;



    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping( method = RequestMethod.POST)
    public Reading create(@RequestBody Reading reading) {
        service.createReading(reading);
        return reading;
    }


}
