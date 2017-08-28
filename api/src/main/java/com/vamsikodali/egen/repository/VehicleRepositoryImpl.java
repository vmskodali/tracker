package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createVehicle(Vehicle v) {
        entityManager.persist(v);
    }

    public void updateVehicle(Vehicle v) {
        entityManager.merge(v);
    }

    public Vehicle findOne(String id) {
        return entityManager.find(Vehicle.class, id);
    }

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll",
                Vehicle.class);
        return query.getResultList();
    }
}
