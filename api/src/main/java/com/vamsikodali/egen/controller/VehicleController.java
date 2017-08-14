package com.vamsikodali.egen.controller;


import com.vamsikodali.egen.Entity.Vehicle;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
public class VehicleController {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    @RequestMapping(value = "vehicles", method = RequestMethod.PUT)
    public Vehicle create(@RequestBody Vehicle veh) {
        entityManager.persist(veh);
        return veh;
    }

}
