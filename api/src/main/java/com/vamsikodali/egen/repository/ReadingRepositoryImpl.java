package com.vamsikodali.egen.repository;

import com.vamsikodali.egen.Entity.Alert;
import com.vamsikodali.egen.Entity.Reading;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void createReading(Reading reading) {
        entityManager.persist(reading.getTires());
        entityManager.persist(reading);
    }

    public List<Reading> findReadingsByVehicle(String vin) {
        TypedQuery<Reading> query = entityManager.createQuery("SELECT r FROM Reading r where r.vin=:vin and r.timestamp>:timestamp ORDER BY r.timestamp DESC ",
                Reading.class);
        query.setParameter("vin", vin);
        query.setParameter("timestamp", new Date(System.currentTimeMillis() - 1800 * 1000 ));
        return query.getResultList();
    }
}
