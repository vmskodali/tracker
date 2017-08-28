package com.vamsikodali.egen.controller;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Vehicle;
import com.vamsikodali.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
public class AlertController {
    @Autowired
    AlertService service;
    @RequestMapping(method = RequestMethod.GET)
    public List<Alert> findAll() {
        return service.findAllAlerts();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicle/{vin}")
    public  List<Alert> findAlertsByVehicle(@PathVariable("vin")String vin){
        return service.findAlertsByVehicle(vin);
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/vehicle/{vin}")
    public  List<Alert> findAlertsByVehicle(@PathVariable("vin")String vin){
        return service.findAlertsByVehicle(vin);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/sendAlert/{email}")
    public  void sendAlert(@PathVariable("email")String email){
        service.findAlertsByVehicle(email);
    }
}
